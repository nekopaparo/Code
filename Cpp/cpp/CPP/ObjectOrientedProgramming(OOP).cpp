#include <iostream>

using namespace std;

class ClassTest_1 {

private:

    string str_1;
    string str_2;

public:

    ClassTest_1(){};

    ClassTest_1(string str_1, string str_2){
        this->str_1 = str_1;
        this->str_2 = str_2;
    };

    void func(){
        cout << "str_1 = " << str_1 << endl;
        cout << "str_2 = " << str_2 << endl;
    };
    //虛擬函式 virtual function，不強制子類別一定要實作，以子類別為優先
    virtual void vfunc() {
        cout << "FAQ" << endl;
    };
};
class Pvfunc{ //本類別無法實體化

public:
    //純虛函式 pure virtual function，強制子類別必須override，使用後該類別無法被實體化
    virtual void pvfunc() = 0;

};
class ClassTest_2: public ClassTest_1, public Pvfunc{ //多個繼承

public:

    void pvfunc() override{
        cout << "YABAI" << endl;
    }

    void vfunc() {
        cout << "MDFK" << endl;
    }

};

int main(void){

    ClassTest_1 ct1 = ClassTest_1("Hello", "World");
    // ClassTest_1 ct1("Hello", "World");
    ct1.func();

    ClassTest_2 ct2 = ClassTest_2();
    ct2.pvfunc();
    ct2.vfunc();

    //指標test
    ClassTest_1 *p = &ct2;
    p->vfunc(); //把ClassTest_1的vfunc()的virtual刪掉結果會不一樣

    return 0;
}
