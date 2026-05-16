import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = 0;
        long maxTime = 0;
        for(int time : times) maxTime = Math.max(time, maxTime);
        right = maxTime * n;
        while(left + 1 < right){
            long mid = (left + right) / 2;
            // 성공
            if(pos(mid, times, n)) right = mid;
            //실패
            else left = mid;
        }
        return right;
    }
    public boolean pos(long num, int[] times, int n){
        //num 시간
        // times 심사 시간
        // n 사람 수
        long count = 0;
        for(int time : times) count += num / time;
        return count >= n;
    }
}