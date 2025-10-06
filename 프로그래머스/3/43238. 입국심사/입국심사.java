import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        // 범위이르모 왼쪽 0 오른쪽 n / times의 맥스
        int maxTime = -1;
        for(int i=0; i<times.length; i++) maxTime = Math.max(times[i], maxTime);
        long left = 0;
        long right = (long)n * maxTime;
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            if(check(mid, n, times)){
                answer = mid;
                right = mid-1;
            }else left = mid+1;
        }
        return answer;
    }
    
    public boolean check(long time, int n, int[] times){
        int tl = times.length;
        long total = 0;
        for(int i=0; i<tl; i++){
            total += (time / times[i]);
        }
        return total >= n;
    }
}