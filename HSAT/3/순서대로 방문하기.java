import java.io.*;
import java.util.*;

public class Main {

    static Pos[] should;
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int[] dr = {0, -1, 1, 0};
    static int[] dc = {-1, 0, 0, 1};
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        should = new Pos[m];
        result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            should[i] = new Pos(r, c);
        }

        DFS(should[0].r, should[0].c, 0);

        System.out.print(result);
    }

    static void DFS(int r, int c, int cnt) {
        // 현재 위치가 경유 지점인 경우
        if (r == should[cnt].r && c == should[cnt].c) {
            cnt++;
            // 마지막 경유 지점에 도달한 경우
            if (cnt == m && r== should[m-1].r && c== should[m-1].c) {
                result++;
                return;
            }
        }

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (check(newR, newC, visited)) {
                DFS(newR, newC, cnt);
            }
        }

        visited[r][c] = false; 
    }

    static boolean check(int r, int c, boolean[][] visited) {
        return r >= 0 && r < n && c >= 0 && c < n && arr[r][c] != 1 && !visited[r][c];
    }

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
