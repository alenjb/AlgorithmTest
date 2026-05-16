import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int n = words.length + 2;
        String [] words2 = new String [n];
        for(int i=0; i<n-2; i++){
             words2[i] = words[i];
        }
        words2[n-2] = begin;
        words2[n-1] = target;
        boolean [] visited = new boolean[n];
        int [] dist = new int [n];

        //BFS
        List<Integer> [] arr = new List[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();
        
        for(int i=0 ;i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(isOneDiff(words2[i], words2[j])) {
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }
        
        int bIdx = n-2;
        int tIdx = n-1;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(bIdx);
        visited[bIdx] = true;
        int maxCount = 0;
        while(!q.isEmpty()){
            int poll = q.poll();
            for(int next : arr[poll]){
                if(!visited[next]){
                    visited[next] = true;
                    dist[next] = dist[poll] + 1;
                    if(words2[next].equals(target) && next!= tIdx) return dist[next];
                    q.add(next);
                }
            }
        }
        return 0;
    }
    public boolean isOneDiff(String a, String b){
        int n = a.length();
        int diff = 0;
        for(int i=0; i<n; i++){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if(c1 != c2) diff++;
            if(diff >1) return false;
        }
        if(diff == 1) return true;
        return false;
    }
}