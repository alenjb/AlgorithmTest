import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(c == '(') st.add(c);
            else{
                if(st.isEmpty()) return false;
                else if(st.peek() == ')') return false;
                else st.pop();
            }
            
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}