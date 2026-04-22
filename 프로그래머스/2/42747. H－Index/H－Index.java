import java.util.*;

class Solution {
    public int solution(int[] cit) {
        Arrays.sort(cit);
        int n = cit.length;
        
        for (int i = 0; i < n; i++) {
            int h = n - i; // 이 위치에서 가능한 H값
            
            if (cit[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}