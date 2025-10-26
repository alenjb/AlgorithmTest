import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        // 최소 0 최대 n * maxTime
        long maxTime = 0;
        for(int time : times) maxTime = Math.max(maxTime, time);
        
        long left = 0;
        long right = n * maxTime;
        while(left+1 < right){
            long mid = (left + right) / 2;
            if(check(mid, times, n)){
                right = mid;
            }else left = mid;
        }
        return right;
    }
    
    static boolean check(long num, int[] times, int n){
        long answer = 0;
        for(int time : times) answer += (num / time);
        return answer >= n;
    }
}