#include <iostream>

using namespace std;

int main(void){

    FILE *fp;
    FILE *fr;
    //讀檔
    fp = fopen("test.txt", "r");
    if(fp == NULL){
        cout << "File not found.\n";
    }
    else{
        char c[100];
        int i=1;
        while(1){
            fgets(c, 99, fp);
            if(feof(fp)) break;
            printf("%d\t%s", i, c);
            i++;
        }
    }
    fclose(fp);

    //寫檔
    fr=fopen("test.txt", "w"); // w -> 覆蓋, a -> 接續寫入
    fputs("test\n", fr); //寫入檔案
    fprintf(fr, "%s%d\n", "nekopapa use c", 8763); //指定形式寫入
    fclose(fr);

    //圖片複製(二進位檔)
    short buf[256];
    fp=fopen("input.jpg", "rb");
    if(fp == NULL){
        cout << "File not found.\n";
    }
    else{
        fr=fopen("output.jpg", "wb"); //ab
        while(1){
            fread(buf, sizeof(short), 256, fp); //(緩衝區, 讀/寫基本單位(byte), 讀/寫次數, 檔案)
            fwrite(buf, sizeof(short), 256, fr); //sizeof(short)=2byte，緩衝區大小=256*2=512byte
            if(feof(fp)) break;
        }
        fclose(fr);
    }
    fclose(fp);

    return 0;

}
