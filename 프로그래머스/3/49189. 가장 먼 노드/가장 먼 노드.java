import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer> [] arr = new List[n+1];
        for(int i=0; i<n+1; i++) arr[i] = new ArrayList<>();
        boolean [] visited = new boolean [n+1];
        int [] dist = new int [n+1];
        
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        int depth = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next : arr[now]){
                if(!visited[next]) {
                    q.add(next);
                    dist[next] = dist[now]+1;
                    visited[next] = true;
                }
            }
        }
        for(int nn : dist){
            System.out.println(nn);
        }
        int maxDepth = 0;
        for(int i=0; i<n+1; i++) maxDepth = Math.max(maxDepth, dist[i]);
        int answer = 0;
        for(int i=0; i<n+1; i++) {
            if(maxDepth == dist[i]) answer++;
        }
        return answer;
    }
}