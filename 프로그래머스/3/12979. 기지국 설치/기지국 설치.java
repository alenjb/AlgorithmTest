import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int start = 1;
        int answer = 0;
        for(int st : stations){
            int cant = st - w - start; // 커버 못하는 범위
            if (cant > 0){
                int need = (int)Math.ceil((double)cant / (2*w +1)); // 필요한 개수
                answer += need;                
            }
            start = st + w + 1;
        }
        
        //마지막 남은 구역
        if(start <= n){
            int cant = n - start + 1; // 커버 못하는 범위
            if (cant > 0){
                int need = (int)Math.ceil((double)cant / (2*w +1)); // 필요한 개수
                answer += need;        
            }
        }
        return answer;
    } 
}