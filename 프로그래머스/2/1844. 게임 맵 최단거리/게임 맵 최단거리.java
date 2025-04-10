import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int r = 0;
    static int c = 0;
    static int [] dr = {0, -1, 1, 0}; // 왼 위 아래 오른
    static int [] dc = {-1, 0, 0, 1}; // 왼 위 아래 오른
	public int solution(int[][] maps) {
        r = maps.length;
        c = maps[0].length;        
        BFS(maps);

        if(answer == Integer.MAX_VALUE) return -1;
		return answer;
	}
    
    //BFS
    public void BFS(int[][]maps){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        boolean [][] visited = new boolean [r][c];
        visited[0][0] = true;

        while(!q.isEmpty()){
            int [] now = q.poll();
            int nowR = now[0];
            int nowC = now[1];
            int cost = now[2];
            
            // r-1, c-1에 도달하면 종료
            if(nowR == r-1&& nowC == c-1){
                answer = Math.min(answer, cost);
                return;
            }
            
            
            // 동서남북으로 BFS
            for(int i=0; i<4; i++){
                int newR = nowR + dr[i];
                int newC = nowC + dc[i];
                if(newR >= 0 && r > newR && newC >=0 && newC <c && !visited[newR][newC]
                  && maps[newR][newC] == 1){
                    visited[newR][newC] = true;
                    q.add(new int[]{newR, newC, cost+1});
                }
            }
        }
    }
}