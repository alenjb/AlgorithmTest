import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        boolean answer = true;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(st.isEmpty() || c == '(') st.push(c);
            else if(c == ')' && st.peek() == '('){
                st.pop();
            }else {
                answer = false;
                break;
            }
        }
        return answer && st.isEmpty();
    }
}