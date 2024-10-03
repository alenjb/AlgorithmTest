import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 0 ~ 7 * n 이분탐색
        long min = Long.MAX_VALUE;
        for(long t : times) min = Math.min(min, t);
        long answer = bs(0, n * min, n, times);
     
        return answer;
    }
    // start는 uncheck, end는 check
    static long bs(long start, long end, int n, int[] times){
        while(start + 1 < end ){
            long mid = (start + end) / 2;
            if(check(n, mid, times)) end = mid;
            else start = mid;
        }
        return end;
    }
    static boolean check(long n, long num, int[] times){
        long cnt = 0;
        for(long time : times){
            cnt += num / time; // 심사 가능한 사람 수
        }
        return n <= cnt;        
    }
}