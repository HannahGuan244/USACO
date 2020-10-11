#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <string>
#include <set>
#include <map>
#include <stack>
#include <queue>
using namespace std;

long N, answer;

long count(long n);
int main()
{
    ifstream fin("moobuzz.in");
    fin >> N;

    int a = floor((N-1)/8);
    int b = N%8;
    if (b==0) b=8;
    cout << a << " " << b<<"\n";

    if (b <= 2) answer = a*15+b;
    else if (b==3) answer = a*15+4;
    else if (b<=5) answer = a*15+b+3;
    else if (b==6) answer = a*15+11;
    else answer = a*15+b+6;
    ofstream fout("moobuzz.out");
    fout << answer <<"\n";
    return 0;
}

long count(long n){
    return n-floor(n/3)-floor(n/5) + floor(n/15);
}
