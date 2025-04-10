import java.util.*;
class Solution {
    static List<Integer>[] arr;
    static int [] cost;
    public int solution(int n, int[][] edge) {
        arr = new List [n+1];
        cost = new int [n+1];
        for(int i=0; i<n+1; i++) arr[i] = new ArrayList<>();
        int r = edge.length;        
        for(int i=0; i<r; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        int answer = 0;
        int max_val = -1;
        Queue<int []> q = new ArrayDeque<>();
        boolean [] visited = new boolean [n+1];
        
        q.add(new int []{1, 0});
        visited[1] = true;
        //BFS
        while(!q.isEmpty()){
            int [] now = q.poll();
            int pos = now[0];
            int val = now[1];
            
            max_val = Math.max(val, max_val);
            cost[pos] = val;
            
            for(int next : arr[pos]){
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new int [] {next, val+1});                    
                }
            }
        }
        
        // for(int nn : cost){
        //     // System.out.println(nn);
        //     if(max_val == nn) answer++;
        // }
        for(int i = 0; i < cost.length; i++) {
            if(max_val == cost[i]) answer++;
        }


        
        return answer;
    }
}