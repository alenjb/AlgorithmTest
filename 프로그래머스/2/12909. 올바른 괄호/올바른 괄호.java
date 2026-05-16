import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            // (가 들어오면 넣기
            if(c == '(') st.push(c);
            else{
            // )가 들어오면 빼기
                // 뺄게 없으면 false OR )가 나오면 false;
                if(st.isEmpty() || st.peek() == ')') return false;
                // (가 나오면 빼고 넘어가기
                else if(st.peek() == '(') st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        return answer;
    }
}