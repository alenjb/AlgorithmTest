import java.util.*;
class Solution {
    static int R, C;
    static int [] posR = {0, -1, 0, 1}; //왼 위 오 아
    static int [] posC = {-1, 0, 1, 0}; //왼 위 오 아
    static boolean [][] visited;

    
	public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        
        //BFS
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 1));

        visited = new boolean [R][C];
        visited[0][0] = true;
        while(!q.isEmpty()){
            Pos poll = q.poll();
            
            //만약 도착했으면 리턴
            if(poll.r == R-1 && poll.c == C-1) return poll.cnt;
            
            for(int i=0; i<4; i++){
                int newR = poll.r + posR[i];
                int newC = poll.c + posC[i];

                // 유효성 검사
                if(newR <0 || newR >= R || newC <0 || newC >=C 
                   || maps[newR][newC] == 0 || visited[newR][newC]) continue;
                
                visited[newR][newC] = true;
                q.add(new Pos(newR, newC, poll.cnt+1));
            }
        }
		return -1;
	}
    
    static class Pos{
        int r;
        int c;
        int cnt;

        
        public Pos(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}