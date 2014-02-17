/*
 * File:   main.cpp
 * Author: Joey
 *
 * Created on December 16, 2012, 1:36 AM
 */

#include <iostream>
#include <cstdlib>
#include <time.h>
using namespace std;

int nextInt(int a);

class UnitCircleExpression
{
    static const string TRIG_FUNCTIONS[];
    static const string ANGLES[];
    static const string ANSWERS[][5];
    static const unsigned char TF;
    static const unsigned char ANGLE;
    static const unsigned char SIGN;
    const unsigned char DAT;
    const string CORRECT;
    string initCORRECT();
    unsigned char initDAT();
    unsigned char getTF();
    unsigned char getAngle();
    unsigned char getSign();
public:
    UnitCircleExpression()
       :DAT(initDAT()),
        CORRECT(initCORRECT())
//       :DAT(0),
//        CORRECT("")
        {};
    string toString();
    bool isCorrect(string);
    string getCorrect();
};
const string UnitCircleExpression::TRIG_FUNCTIONS[] =
{
    "sin","cos","tan","cot","sec","csc",
};
const string UnitCircleExpression::ANGLES[] =
{
        "0","pi/6","pi/4","pi/3",
        "pi/2","5pi/6","3pi/4","2pi/3",
        "pi","7pi/6","5pi/4","4pi/3",
        "3pi/2","11pi/6","7pi/4","5pi/3",
};
const string UnitCircleExpression::ANSWERS[][5] =
{
        {"0","1/2","rt2/2","rt3/2","1"},
        {"1","rt3/2","rt2/2","1/2","0"},
        {"0","rt3/3","1","rt3","undef"},
        {"undef","rt3","1","rt3/3","0"},
        {"1","2rt3/3","rt2","2","undef"},
        {"undef","2","rt2","2rt3/3","1"},
};
const unsigned char UnitCircleExpression::TF =    0b01110000;
const unsigned char UnitCircleExpression::ANGLE = 0b00001111;
const unsigned char UnitCircleExpression::SIGN =  0b10000000;
unsigned char UnitCircleExpression::getTF()
{
    return (DAT & TF) >> 4;
}
unsigned char UnitCircleExpression::getAngle()
{
    return DAT & ANGLE;
}
unsigned char UnitCircleExpression::getSign()
{
    return (DAT & SIGN) >> 7;
}
unsigned char UnitCircleExpression::initDAT()
{
    unsigned char temp = nextInt(95);
    temp += nextInt(2) * SIGN;
    return temp;
}
string UnitCircleExpression::initCORRECT()
{
    unsigned char angleType;
    unsigned char angle = getAngle();
    if(angle % 4 == 0)
        angleType = angle % 8;
    else
        angleType = angle % 4;
    unsigned char tF = getTF();
    string cor = "";
    cor = ANSWERS[tF][angleType];

    if((tF == 1 || tF == 4) && 4 < angle && angle < 12)
        cor = "-" + cor;
    else if(getSign())
    {
        //if sin/cos and angle is in III or IV
        if((tF == 0 || tF == 5) && angle < 8 && angle > 0)
            cor = "-" + cor;
        //if tan/cot angle is in II or IV
        else if((tF == 2 || tF == 3) && ((angle - 1) / 3 == 0 || angle / 3 == 3))
            cor = "-" + cor;
    }
    else
    {
        //if sin/cos and angle is in III or IV
        if((tF == 0 || tF == 5) && angle > 8)
            cor = "-" + cor;

        //if tan/cot and angle is in II or IV
        else if((tF == 2 || tF == 3) && ((angle + 1) / 3 == 2 || (angle - 1) / 3 == 4))
            cor = "-" + cor;
    }
    return cor;
}
string UnitCircleExpression::toString()
{
    string returnMe = "";
    returnMe += TRIG_FUNCTIONS[getTF()];
    returnMe += "(";
    returnMe += getSign() ? "-" : "";
    returnMe += ANGLES[getAngle()];
    returnMe += ")";
    return returnMe;
}
bool UnitCircleExpression::isCorrect(string ans)
{
    return ans == CORRECT;
}
string UnitCircleExpression::getCorrect()
{
    return CORRECT;
}

class DataSet
{
    int sum;
    int maximum;
    int minimum;
    int count;
public:
    void add(int x)
    {
        sum += x;
        if(count == 0 || maximum < x)
            maximum = x;
        if(count == 0 || minimum > x)
            minimum = x;
        count++;
    }
    int getMaximum(){return maximum;}
    int getMinimum(){return minimum;}
    int getSum(){return sum;}
    int getAverage()
    {
        if(count == 0)
            return 0;
        return sum / count;
    }
}d;
int nextInt(int a)
{
    int z = rand() % 17;
    for(int i = 0; i < z; i++)
        rand();
    int r = a*rand() / RAND_MAX;
    return r;
}
void test();
int main()
{
    test();
//    srand(time(0));
//    cout << "Welcome." << endl;
//    cout << "Press Enter to begin:" << endl;
//    string s;
//    cin >> s;
//    UnitCircleExpression exps[10];
//    bool correct[10];
//    for(int i = 0; i < 10; i++)
//    {
//        cout << exps[i].toString() << "?" << endl;
//
//        int start = time(0);
//        string ans;
//        getline(cin,ans);
//        d.add((int)time(0) - start);
//
//        correct[i] = exps[i].isCorrect(ans);
//    }
//    for(int i = 0; i < 10; i++)
//    {
//        cout << correct[i] ? "true " : "false ";
//    }
//    cout << endl;
//
//    cout << "Total time: " << d.getSum() << endl;
//    cout << "Slowest: " << d.getMaximum() << endl;
//    cout << "Fastest: " << d.getMinimum() << endl;
//    cout << "Average: " << d.getAverage() << endl;
    return 0;
}

void test()
{
    cout << "hi" << endl;
    string in;
    getline(cin,in);
    cout << in << endl;
}