import java.util.*;
class Solution {
    static boolean [] visited;
    static int[][] computers;
    public int solution(int n, int[][] c) {
        visited  = new boolean [n];
        computers = c;
        
        int cnt = 0;
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                BFS(i);
                cnt++;
            }
        }
        return cnt;
    }

    static void BFS(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<computers[now].length; i++){
                if(computers[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}