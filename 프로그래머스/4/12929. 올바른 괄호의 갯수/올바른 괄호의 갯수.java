import java.util.*;
class Solution {
    static Set<String> set = new HashSet<>();
    public int solution(int n) {
        
        //DFS
        DFS("(", n * 2, 1, 0);
        int answer = 0;
        for(String ss : set) if(isValid(ss)) answer++;
        return answer;
    }
    
    // 일단 다 만들기
    public void DFS(String now, int n, int left, int right){
        int nl = now.length();
        // 가망없으면 종료(현재 격차를 남은 걸 다 떄려박아도 못메꾸면)
        if(left > n/2 || right > n/2) return;
        // 완성은 추가
        if(nl == n) {
            set.add(now);
            return;
        }else if(nl == n-1){ // 마지막은 )
            DFS(now + ")", n, left, right+1);
            return;
        }else{
            // 미완성은 다시 DFS
            DFS(now + "(", n, left+1, right);
            if(left > right) DFS(now + ")", n, left, right+1);
            return;
        }
    }
    // 괄호가 정상인지 판단
    public boolean isValid(String s){
        int l = s.length();
        int left = 0; // (
        int right = 0; // )
        Queue<Character> q = new ArrayDeque<>();
        for(int i=0; i<l; i++){
            char c = s.charAt(i);
            // ( 이면 넣기
            if(c == '(') q.offer(c);
            else{
                // ) 이면
                if(q.isEmpty()) return false;
                char poll = q.poll();
                if(poll == ')') return false;
            }
        }
        return q.size() == 0;
    }
}