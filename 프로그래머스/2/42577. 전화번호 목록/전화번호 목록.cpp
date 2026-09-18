#include <bits/stdc++.h>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;    
    sort(phone_book.begin(), phone_book.end());
    for(int i=0; i< phone_book.size()-1; i++){
        // i- 앞
        if(phone_book[i+1].starts_with(phone_book[i])) return false;
        }
    return answer;
}