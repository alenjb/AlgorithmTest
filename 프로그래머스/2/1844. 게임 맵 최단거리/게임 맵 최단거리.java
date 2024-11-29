import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int r = maps.length;
        int c = maps[0].length;
        
        int [] dr = {0, 1, -1, 0};
        int [] dc = {-1, 0, 0, 1};
        
        Queue<int []> q = new ArrayDeque<>();
        boolean [][] visited = new boolean[r][c];
        q.add(new int[]{0, 0, 0}); //r, c, cnt
        while(!q.isEmpty()){
            int [] now = q.poll();
            if(visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            
            now[2]++;
            if(now[0] == r-1 && now[1] == c-1){
                answer = now[2];
                break;
            }
            
            for(int i=0; i<4; i++){
                int newR = now[0] + dr[i];
                int newC = now[1] + dc[i];
                if(newR >=0 && newR < r && newC >=0 && newC < c && maps[newR][newC]!=0 && !visited[newR][newC]) q.add(new int []{newR, newC, now[2]});
            }
            
        }
        return answer;
    }
}