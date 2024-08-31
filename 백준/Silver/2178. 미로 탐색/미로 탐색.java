import java.io.*;
import java.util.StringTokenizer;

import java.util.*;
public class Main {
    static int [][] arr;
    static int [] dx = {-1, 0, 0, 1};
    static int [] dy = {0, 1, -1, 0};
    static boolean [][] visited;
    static int N, M, result;
    static Queue<int []> q = new ArrayDeque();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0 ;i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        q.add(new int [] {0,0,1});
        result = 0;
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int cnt = poll[2];

            if(visited[r][c]) continue;
            visited[r][c] = true;

            if(r == N-1 && c == M-1) {
                result  = cnt;
                break;
            }

            for(int i=0; i<4; i++){
                int newR = dy[i] + r;
                int newC = dx[i] + c;
                if(check(newR, newC) && !visited[newR][newC] && arr[newR][newC]==1) {
                    q.add(new int [] {newR, newC, cnt+1});
                }
            }
        }
        System.out.println(result);
    }


    static boolean check(int r, int c){
        return r<N && r >=0 && c<M && c>=0;
    }
}