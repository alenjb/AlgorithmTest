import java.util.*;
class Solution {
    static boolean [][] visited;
    static int [] dr = new int [] {0, -1, 0, 1};
    static int [] dc = new int [] {-1, 0, 1, 0};
    static int R, C;
    public int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        visited = new boolean[R][C];
        int num = 2; // 같은 블럭인지 표시
        Map<Integer, Integer> map = new HashMap<>();
        
        // 1마다 visited가 아니면 BFS (500 * 500)
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    map.put(num, BFS(i, j, num, land));
                    num++;
                }
            }
        }
        
        // 각 열마다 개수 세기 ( 500 * 500)
        Set<Integer> set = new HashSet<>();
        int max = -1;
        for(int i=0; i<C; i++){
            for(int j=0; j<R; j++){
                if(land[j][i]>1) set.add(land[j][i]);
            }
            int sum = 0;
            for(int block : set){
                sum += map.get(block);
            }
            max = Math.max(max, sum);
            set.clear();
        }
        return max;
    }
    
    static int BFS(int r, int c, int now, int[][] land){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r,c});
        visited[r][c] = true;
        int blockSize = 0;
        while(!q.isEmpty()){
            int [] poll = q.poll();
            int pollR = poll[0];
            int pollC = poll[1];
            land[pollR][pollC] = now;
            blockSize++;
            
            for(int i=0; i<4; i++){
                int newR = pollR + dr[i];
                int newC = pollC + dc[i];
                if(newR >=0 && newR < R && newC >=0 && newC < C && !visited[newR][newC] && land[newR][newC] == 1){          
                    visited[newR][newC] = true;
                    q.add(new int[]{newR, newC});
                }
            }
        }
        return blockSize;
    }    
}