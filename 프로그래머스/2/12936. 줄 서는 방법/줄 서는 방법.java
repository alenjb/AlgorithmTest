import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        // 전체 수 n! = 1 * ~ n
        // 맨 앞자리부터 끊기 (n-1)! 씩 끊었을 때 어디인지
        // 후보
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);
        int[] answer = new int[n];
        k--;
        
        for(int i=0; i<n; i++){
            int digit = (int) (k / fact(n - i -1));
            k = (k % fact(n - i -1));
            answer[i] = list.get(digit);
            list.remove(digit);
        }
        return answer;
    }
    
    static long fact(long n){
        if(n <= 1) return 1;
        return fact(n-1) * n;
    }
}