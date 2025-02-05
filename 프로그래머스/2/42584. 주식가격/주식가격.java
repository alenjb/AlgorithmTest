import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int [] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for(int i=1; i<n; i++){
            int now = prices[i];
            if(!stack.isEmpty() && prices[stack.peek()] > now){
                while(!stack.isEmpty() && prices[stack.peek()] > now){
                    // 빼기
                    answer[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                int now = stack.pop();
                answer[now] = n-1 - now;                
            }
        }
        return answer;
    }
}