import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int l = times.length;        
        int left = 0;
        int diffMax = -1;
        for(int diff : diffs) diffMax = Math.max(diffMax, diff);
        int right = diffMax;
        
        while(left +1 < right){
            int mid = (left + right) / 2;
            // 통과
            if(poss(mid, diffs, times, limit)) right = mid;
            //실패
            else left = mid;
        }
        return right;
    }
    
    public boolean poss(int level, int[] diffs, int[] times, long limit){
        int l = times.length;
        long total = 0;
        for(int i=0; i<l; i++){
            int diff = diffs[i];
            int d = diff - level;
            int cur_time = times[i];
            int prev_time = 0;
            if(i >0) prev_time = times[i-1];
            
            // 작은경우
            if(d > 0){
                total += (d * (cur_time + prev_time) + cur_time);
            }
            // 같거나 레벨이 높은 경우
            else{
                total += cur_time;                
            }
            if(limit < total) return false;
        }
        return true;        
    }
}