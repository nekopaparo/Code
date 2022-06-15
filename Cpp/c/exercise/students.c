#include <stdio.h>

#define FILE_NAME "D:\\file.txt"
#define FILE_OUTPUT_NAME "D:\\fileOutput.txt"
#define CLASS_MAX_SIZE 100
#define SUBJECT 6

struct Student
{
    int data[SUBJECT+1], rank;
    float avg;
};

void readStudentFile (struct Student *readOutput, int *CLASS_SIZE, float *dataAvg, int *range); // 讀檔案
void writeStudentFile (struct Student *students, struct Student **sortStudents, float *dataAvg, int *range, const int CLASS_SIZE); // 寫檔
void sorting (struct Student *data, struct Student **sortOutput, const int CLASS_SIZE); // 排名
int binarySearch (struct Student** sortData, const float avg, const int begin, const int end); // 二元搜尋法 (計數用)

void log (struct Student *students, struct Student **sortStudents, float *dataAvg, int *range, const int CLASS_SIZE);

int main()
{
    struct Student students[CLASS_MAX_SIZE], *sortStudents[CLASS_MAX_SIZE];
    int CLASS_SIZE = 0, // data人數
          range[10] = {0}; // 區間統計
    float dataAvg[SUBJECT+2] = {0}; // 分數統計


    readStudentFile(&students, &CLASS_SIZE, &dataAvg, &range); // 讀檔 + 分數統計 + 區間統計
    sorting (&students, &sortStudents, CLASS_SIZE); // 排名
    writeStudentFile(&students, &sortStudents, &dataAvg, &range, CLASS_SIZE);

    //log(&students, &sortStudents, &dataAvg, &range, CLASS_SIZE);

    return 0;
}
// 讀檔案
void readStudentFile(struct Student *readOutput, int *CLASS_SIZE, float *dataAvg, int *range) {
    FILE *file;
    int member, score;

    if ((file = fopen(FILE_NAME, "r")) == NULL)
    {
        printf("Error! opening file");
        // Program exits if the file pointer returns NULL.
        exit(1);
    }

    while (fscanf(file, "%d", &member) != EOF)
    {
        struct Student student = { .avg = 0 };
        *student.data = member;
        for (int subject = 1; subject <= SUBJECT; ++subject)
        {
            fscanf(file, "%d", &score);
            student.data[subject] = score;
            student.avg += score;
            dataAvg[subject] += score; // 分數統計 (各科累加)
        }
        student.avg /= SUBJECT;
        dataAvg[SUBJECT+1] += student.avg; // 分數統計 (平均累加)
        range[(int)student.avg / 10]+=1; // 區間統計
        readOutput[(*CLASS_SIZE)++] = student;
    }
    fclose(file);
}
// 寫檔
void writeStudentFile(struct Student *students, struct Student **sortStudents, float *dataAvg, int *range, const int CLASS_SIZE) {
    FILE *file;
    int i, j;

    if ((file = fopen(FILE_OUTPUT_NAME, "w")) == NULL)
    {
        fprintf(file, "Error!");
        exit(1);
    }

    // 標題
    fprintf(file, "學號\t");
    for (i = 1; i <= SUBJECT; ++i)
    {
        fprintf(file, "科目%d\t", i);
    }
    fprintf(file, "平均\t名次\n");
    // 內容
    for (i = 0; i < CLASS_SIZE; ++i)
    {
        for (j = 0; j <= SUBJECT; ++j)
        {
            fprintf(file, "%d\t", students[i].data[j]);
        }
        fprintf(file, "%.1f\t%d\n", students[i].avg, students[i].rank);
    }
    fprintf(file, "---------------------------------------------------------------------\n");
    // (1)平均統計
    fprintf(file, "統計\t");
    for (i=1; i < SUBJECT+2; ++i)
    {
        fprintf(file, "%.1f\t", dataAvg[i] / CLASS_SIZE);
    }
    fprintf(file, "\n");
    fprintf(file, "---------------------------------------------------------------------\n");
    // (2)區間統計
    fprintf(file, "學期平均各區間\n");
    for (i=0; i < 10; ++i)
    {
        fprintf(file, "%2d ~ %2d : %d\n", i*10, i*10+9, range[i]);
    }
    fprintf(file, "---------------------------------------------------------------------\n");
    // (3)計數
    int avgUp = binarySearch (sortStudents, dataAvg[SUBJECT+1] / CLASS_SIZE , 0, CLASS_SIZE);
    while (sortStudents[avgUp+1] -> rank == sortStudents[avgUp] -> rank)
    {
        ++avgUp;
    }
    fprintf(file, "平均以上 : %d\n平均以下 : %d", avgUp + 1, CLASS_SIZE - (avgUp + 1));

    fclose(file);
}
// 排名
void sorting (struct Student *data, struct Student **sortOutput, const int CLASS_SIZE) {
    int i, j;
    struct Student *tmp;
    // 建立指標陣列(array of pointers)
    for (i = 0; i < CLASS_SIZE; ++i)
    {
        sortOutput[i] = &data[i];
    }
    // 用平均排序
    for (i = 0; i < CLASS_SIZE-1; ++i)
    {
        for (j = i+1; j < CLASS_SIZE; ++j)
        {
            if (sortOutput[j]->avg > sortOutput[i]->avg)
            {
                tmp = sortOutput[i];
                sortOutput[i] = sortOutput[j];
                sortOutput[j] = tmp;
            }
        }
    }
    // 轉成名次
    (*sortOutput)->rank = 1;
    for (i = 1; i < CLASS_SIZE; ++i)
    {
        if (sortOutput[i]->avg == sortOutput[i-1]->avg)
        {
            sortOutput[i]->rank = sortOutput[i-1]->rank;
        }
        else
        {
            sortOutput[i]->rank = i + 1;
        }
    }
}
// 二元搜尋法 (計數用)
int binarySearch (struct Student** sortData, const float avg, const int begin, const int end) {
    int index = (int)((begin + end) / 2);
    if (index == begin)
    {
        return begin;
    }
    if (sortData[index]->avg > avg)
    {
        return binarySearch (sortData, avg, index, end);
    }
    else if (sortData[index]->avg < avg)
    {
        return binarySearch (sortData, avg, begin, index);
    }
    else
    {
        return index;
    }
}

void log(struct Student *students, struct Student **sortStudents, float *dataAvg, int *range, const int CLASS_SIZE) {
    int i, j;
    // 標題
    printf("學號\t");
    for (i = 1; i <= SUBJECT; ++i)
    {
        printf("科目%d\t", i);
    }
    printf("平均\t名次\n");
    // 內容
    for (i = 0; i < CLASS_SIZE; ++i)
    {
        for (j = 0; j <= SUBJECT; ++j)
        {
            printf("%d\t", students[i].data[j]);
        }
        printf("%.1f\t%d\n", students[i].avg, students[i].rank);
    }
    // (1)平均統計
    printf("統計\t");
    for (i=1; i < SUBJECT+2; ++i)
    {
        printf("%.1f\t", dataAvg[i] / CLASS_SIZE);
    }
    printf("\n");
    printf("---------------------------------------------------------------------\n");
    // (2)區間統計
    printf("學期平均各區間\n");
    for (i=0; i < 10; ++i)
    {
        printf("%2d ~ %2d : %d\n", i*10, i*10+9, range[i]);
    }
    printf("---------------------------------------------------------------------\n");
    // (3)計數
    int avgUp = binarySearch (sortStudents, dataAvg[SUBJECT+1] / CLASS_SIZE , 0, CLASS_SIZE);
    while (sortStudents[avgUp+1] -> rank == sortStudents[avgUp] -> rank)
    {
        ++avgUp;
    }
    printf("平均以上 : %d\n平均以下 : %d", avgUp + 1, CLASS_SIZE - (avgUp + 1));
}
