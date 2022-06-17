#include <stdio.h>
#include <time.h>

void getTime(int *output);
void reflash(int *time);
void newTime (int *time);

int main()
{
    int time[3] = {0};
    getTime(time);
    reflash(time);
    return 0;
}

void getTime(int *output) {
    struct tm *tm;
    time_t now = time(0);

    if ((tm = localtime (&now)) == NULL)
    {
        printf ("Error extracting time stuff\n");
        exit (0);
    }

    output[0] = tm->tm_hour;
    output[1] = tm->tm_min;
    output[2] = tm->tm_sec;
}
void reflash(int *time) {
    printf ("%02d:%02d:%02d\n", time[0], time[1], time[2]);
    Sleep(1000);
    newTime (time);
}
void newTime (int *time) {
    if (++time[2] == 60)
    {
        time[2] = 0;
        if (++time[1] == 60)
        {
            time[1] = 0;
            if (++*time == 24)
            {
                *time == 0;
            }
        }
    }
    reflash(time);
}