import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long max = Integer.MIN_VALUE;
        for(int i=0; i<times.length; i++){
            max = Math.max(times[i], max);
        }
        return search(n, times, max * n);
    }
    
    public long search(int n, int[] times, long max){
        long right = max;// 정답 범위 포함
        long left = 0;
        while(left +1 < right){
            long mid = (right + left) / 2;
            if(isValid(mid, times, n)) right = mid;
            else left = mid;
        }
        return right;
    }
    public boolean isValid(long num, int[] times, int n){
        long valid = 0; // 처리 가능 사람 수
        for(int time : times){
            valid += (num / time);
        }
        return valid >= n;
    }
}