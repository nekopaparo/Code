#include <iostream>

using namespace std;

//<方法>
string f(int n){
    if(n>10)
        return "Hello\n";
    else
        return "Hi\n";
}
int GCD(int a, int b){
    int c=a%b;
    if(c==0)
        return b;
    else
        return GCD(b,c);
}
//</方法>

class ClassTest{
public:
    ClassTest() {
        c = 5;
        d = 3;
        cout << "a=" << a << ", ";
        cout << "b=" << b << endl;
    }
    ClassTest(int c, int d) {
        ClassTest();
        this->c = c;
        this->d = d;
    }
    int a=1;
    int b=2;
    int method_1(){
        return a+b;
    };
    int method_1(int n){ //overload
        return a+b+n;
    };
    int method_1(double n){ //多載
        return c*d;
    };
    int method_2(); //要實作方法，不然呼叫會ERROR
    int method_3(){
        return a+b+c+d;
    };
//不會被繼承
private:
    int c;
    int d;
};
//實作方法，也會被繼承
int ClassTest::method_2(){
    return a*b;
}

class ExtendsTest: public ClassTest{
public:
    //overwrite
    int method_3(){
        return a+b;
    }
};

//主程式
int main(void){

    cout << "please input n : "; //基本輸出
    int n=5;
    //cin >> n; //基本輸入
    cout << "n = " << n << endl << f(n);

    int bubbleSort[] = {9,3,8,1,6}; //array宣告
    //泡泡排序(for迴圈)
    for(int i=0;i<4;i++){
        for(int j=i+1;j<5;j++){
            if(bubbleSort[i]>bubbleSort[j]){
                int tmp=bubbleSort[i];
                bubbleSort[i]=bubbleSort[j];
                bubbleSort[j]=tmp;
            }
        }
    }
    //while
    cout << "while test : ";
    int i=0;
    while(i<5) {
        cout << bubbleSort[i++];
        if(i==5) continue; //迴圈中略過後面
        cout << ", ";
    }
    cout << endl;

    //switch
    int m=7;
    int d;
    switch(m){
    case 1:case 3:case 5:case 6:case 7:case 8:case 10:case 12:
        d=31;
        break;
    case 2:
        d=28;
        break;
    default:
        d=30;
        break;
    }
    cout << "switch test : m=" << m << ", d=" << d << endl;

    //類別
    ClassTest ct(8,7); //呼叫類別
    ct.a=5;
    ct.b=2;
    cout << ct.method_1() << " : " << ct.method_1(1.0) << " : " << ct.method_2() << endl;

    ExtendsTest et;
    cout << et.method_3() << " : " << et.method_1() << " : " << et.method_2() << endl;

    return 0;
}


