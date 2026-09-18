#include <bits/stdc++.h>
using namespace std;

string solution(vector<string> parti, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> map;
    for(string person : completion){
        map[person]++;
    }
    for(string p : parti){
        if(map[p] >0) {
            map[p]--;
        }else{
            answer = p;
            break;
        }
    }
    return answer;
}