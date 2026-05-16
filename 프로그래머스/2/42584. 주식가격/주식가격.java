import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int [n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1; i<n; i++){
            if(stack.isEmpty()) stack.push(i);
            else{
                int peek = stack.peek();
                if(prices[peek] > prices[i]){ // 떨어졌으면
                    while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){// 똑같거나 큰거 찾을 때까지 빼기 
                        int pop = stack.pop();
                        answer[pop] = i - pop;
                    }
                }
            }
            stack.push(i);

        }
        while(!stack.isEmpty()){
            int pop = stack.pop();
            answer[pop] = n - 1 - pop;
        }
        return answer;
    }
}