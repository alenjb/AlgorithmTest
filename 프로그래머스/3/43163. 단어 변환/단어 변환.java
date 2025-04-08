import java.util.*;
class Solution {
    static List<Integer> [] arr;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int l = words.length;
        arr = new ArrayList[l+1];
        for(int i=0; i<=l; i++) arr[i] = new ArrayList<Integer>();
        // 1단어 차이인것 연결리스트로 만들기
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(i!=j && isOneDiff(words[i], words[j])){ // 1개만 다르면
                    arr[i].add(j);
                }
            }
        }
        // VISITED 배열 만들기
        boolean [] visited = new boolean[l+1]; // 마지막 인덱스는 begin
        // begin에 대해 1개 차이인 것 연결
        for(int i=0; i<l; i++){
            if(isOneDiff(begin, words[i])){ // 1개만 다르면
                    arr[l].add(i);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.add(l);
        q2.add(0);
        while(!q.isEmpty()){
            int poll = q.poll();
            int poll2 = q2.poll();
            String word;
            if(poll == l) word = begin;
            else{
                word = words[poll];            
            }

            if(!visited[poll] && word.equals(target)) return poll2;
            visited[poll] = true;
            for(int num : arr[poll]){
                if(!visited[num]) {
                    q.add(num);
                    q2.add(poll2+1);
                }
            }
        }
        // BFS를 하면서 타겟이면 종료, visited이면 종료, 연결리스트가 없으면 종료
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
        
    // 같은 글자 개수 세는 함수(1개만 다르면 true 리턴)
    public boolean isOneDiff(String w1, String w2){
        int diff = 0;
        for(int i=0; i<w1.length(); i++){
            if(w1.charAt(i) != w2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}