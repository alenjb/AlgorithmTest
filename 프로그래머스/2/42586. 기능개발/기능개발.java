import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int len = progresses.length;
        int [] remain = new int [len];
        for(int i=0; i<len; i++){
            remain[i] = 100 - progresses[i];
        }
        
    int idx = 0;
    while(idx <len){
        int cnt = 0;
        int time = remain[idx] / speeds[idx];
        if(remain[idx] % speeds[idx] != 0) time++;
        for(int i=idx; i<len; i++){
            remain[i] -= (speeds[i] * time);
}
        for(int i = idx; i<len; i++){

            if(remain[i] <=0) {
                cnt++;
            }else break;
        }
        
        idx+= cnt;
        list.add(cnt);        
    }
        int [] answer = new int [list.size()];
        int lenIdx = 0;
        for(int num : list){
            answer[lenIdx] = num;
            lenIdx++;
        }

        return answer;
    }
}