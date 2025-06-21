import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //인덱스 넣기
        int l = prices.length;
        int [] answer = new int[l];

        for(int i=1; i<l; i++){
            int now = prices[i];
            if(stack.isEmpty()) stack.push(i);
            else{
                int peek = prices[stack.peek()];
                if(peek <= now) stack.push(i);
                else {
                    while(!stack.isEmpty() && prices[stack.peek()] > now){
                        int push_idx = stack.pop();
                        answer[push_idx] = i - push_idx;
                    }
                    stack.push(i);
                }                
            }
        }
        
        while(!stack.isEmpty()){
            int push_idx =stack.pop();
            answer[push_idx] = l - push_idx -1;

        }
        return answer;
    }
}