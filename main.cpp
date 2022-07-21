#include <iostream>
#include <fstream>

using namespace std;


int main()

{
    //---Kintamieji

    double x=0,y=0,xpr,hx,a,n;

    cout<< "Iveskite x pradini"<<endl;
    cin>>xpr;
    cout<< "Iveskite kitimo zinksni"<<endl;
    cin>>hx;
    cout<<"Iveskite skaiciu kieki n"<< endl;
    cin>>n;
    cout<<"Iveskite funkcijos nari a"<<endl;
    cin>>a;



   x=xpr;
    ofstream fin("Resultatai.txt");
     for( int i=0; i<n; i++){

        y=2*(a-x);

     fin<< "x "<<x<< " | "<<"y "<<y<<endl;
     x=x+hx;
     }

     cout<< "Jusu atsakymas ivestas i faila resultatai.txt";



    return 0;
}
