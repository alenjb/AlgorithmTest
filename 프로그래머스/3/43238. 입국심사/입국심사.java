import java.util.*;
class Solution {
    static int [] times;
    static int N;
    static int p;
    public long solution(int n, int[] ti) {
        times = ti;
        N = n;
        p = ti.length;
        
        long min = -1;
        for(int i=0; i<p; i++){
            min = Math.max(min, ti[i]);
        }
        long left = 0;
        long right = n * min;
        while(left+1 < right){
            long mid = (left + right) / 2;
            if(possible(mid)) right = mid;
            else left = mid;
        }
        
        return right;
    }
    public boolean possible(long time){
        long num = 0;
        for(int i=0; i<p; i++){
            num += time/ times[i];
        }
        return num >= N;
    }    
}