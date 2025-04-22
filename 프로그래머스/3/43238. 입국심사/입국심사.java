import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long) Arrays.stream(times).max().getAsInt() * n; // 수정된 부분
        
        while(left + 1 < right){
            long mid = (left + right) / 2;
            if(isValid(mid, times, n)) right = mid;
            else left = mid;
        }
        return right;
    }

    public boolean isValid(long time, int[] times, int n){
        long avail = 0;
        for(int t : times){
            avail += time / t;
        }
        return avail >= n;
    }
}
