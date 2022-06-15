#include <stdio.h>

#define MAX_SIZE 100

int refash(int *integer, int *isPower, int *type);
void intToString(int *p);
void stringToInt(int *equation, char *data, int *maxPower);
void log(int *equation, int maxPower);

int main () {
    int equation[MAX_SIZE] = {0}, maxPower = 0;
    char P[MAX_SIZE], Q[MAX_SIZE] ;
    /* P = 5x^4 + 3x^3 - 2x + 6; */
    /* Q = 6x^5 + 8x^4 + 5x - 7; */
    printf("P = "); gets(&P);
    printf("Q = ");  gets(&Q);

    stringToInt(equation, P, &maxPower);
    stringToInt(equation, Q, &maxPower);
    log(equation, maxPower);
}

int refash(int *integer, int *isPower, int *type) {
    int tmp = (*integer) * (*type);
    *integer = 0;
    *isPower = !(*isPower);
    *type = 1;
    return tmp;
}
void stringToInt(int *equation, char *data, int *maxPower) {
    int index = 0, isPower = 0,
          base, power,
          integer = 0, type = 1;

    for (; data[index] != '\0'; ++index)
    {
        switch(data[index])
        {
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
            integer *= 10;
            integer += data[index] - '0';
            break;
        case 'x':
            base = refash(&integer, &isPower, &type);
            break;
        case '^':
            break;
        case ' ':
            if (isPower)
            {
                power = refash(&integer, &isPower, &type);
                if (!power)
                {
                    power = 1;
                }
                equation[power] += base;
                if (power > *maxPower )
                {
                    *maxPower  = power;
                }
            }
            break;
        case '-':
            type *= -1;
            break;
        }
    }
    *equation += integer * type;
}
void intToString(int *p) {
    if (*p != 0)
    {
        if (*p < 0)
        {
            printf(" - %d", (*p) * -1);
        }
        else
        {
            printf(" + %d", (*p));
        }
    }
}
void log(int *equation, int maxPower) {
    printf("P + Q = %dx^%d", equation[maxPower], maxPower);
    for(int i = maxPower - 1; i > 0; --i)
    {
        if (equation[i] != 0)
        {
            intToString(&equation[i]);
            printf("x");
            if (i > 1)
            {
                printf("^%d", i);
            }
        }
    }
    intToString(equation);
}
