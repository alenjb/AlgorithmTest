import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        // Stack<Charater> lp = new Stack<>();
        // Stack<Charater> rp = new Stack<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{ // ')'인 경우
                if(stack.isEmpty()){
                    return false;
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) answer = false;
        return answer;
    }
}