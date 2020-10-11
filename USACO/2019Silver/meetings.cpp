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

long N, L;
int answer;
vector<pair<int, pair<int, int>>> v;

int main()
{
    int w, x, d;
    ifstream fin("meetings.in");
    fin >> N >> L;
    for (int i = 0; i < N; i++){
        fin >> w >> x >> d;
        v.push_back({2*x, {w, d}});
    }
    sort(v.begin(), v.end());

    answer = 0;
    int total = 0;

    // total weight
    for(int i = 0; i < N; i++) total += v[i].second.first;

    int home = 0;
    int start = 0; int end = N;
    while (home<ceil(total/2)) {
        int next_meet = L;
        bool no_meet = 1;
        // determine when next meet will happen
        for(int i = start; i < end-1; i++) {
            if(v[i].second.second==1 && v[i+1].second.second==-1) {
                next_meet = min(next_meet, (v[i+1].first-v[i].first)/2);
                no_meet = 0;
            }
        }
        if(no_meet) {break;}
        //cout << next_meet<< "\n";
        // update at next meet

        for(int i = start; i < end; i++) {
            v[i].first += v[i].second.second*next_meet;
            if (v[i].first<=0) {
                    home += v[i].second.first;
                    start++;
            }
            else if (v[i].first>=2*L) {
                home += v[i].second.first;
                end--;
            }
            //cout << i+1 <<":" <<v[i].first << v[i].second.second<<";"<<home<<"\n";
        }
        if (home>=ceil(total/2)) break;

        //cout << 1 <<":" <<v[0].first << v[0].second.second<<"\n";
        for(int i = start+1; i < end; i++) {
            if (v[i].first == v[i-1].first) {
                answer++;
                v[i].second.second = -1*v[i].second.second;
                v[i-1].second.second = -1*v[i-1].second.second;
            }
            //cout << i+1 <<":" <<v[i].first << v[i].second.second<<";"<<answer<<"\n";
        }
        //cout << answer <<"\n";
        //for(int i = start; i < end; i++) {
        //    if (v[i].first==0 || v[i].first==2*L) home += v[i].second.first;
        //}
    }
        //cout << v[i].first << " " << v[i].second.first << " " << v[i].second.second << " " << "\n";
    //fcout << answer << "\n";

    ofstream fout("meetings.out");
    fout << answer <<"\n";
    return 0;
}
