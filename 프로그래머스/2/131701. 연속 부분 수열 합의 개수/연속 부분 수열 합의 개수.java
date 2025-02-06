import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int n = elements.length;
        for(int i=0; i<n; i++){ // i는 시작점
            int num = 0;
            for(int j=0; j<n; j++){ // j = 길이
                num +=elements[(j+i) % n];
                set.add(num);
            }
        }
        return set.size();
    }
}