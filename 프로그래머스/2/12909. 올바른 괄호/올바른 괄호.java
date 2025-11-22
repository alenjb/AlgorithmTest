import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> q = new ArrayDeque<>();
        int sl = s.length();
        for(int i=0; i<sl; i++){
            char c = s.charAt(i);
            if(c == '(') q.offer(c);
            else{
                if(q.isEmpty()) return false;
                char poll = q.poll();
                if(poll != '(') return false;
            }
        }
        if(!q.isEmpty()) return false;
        return answer;
    }
}