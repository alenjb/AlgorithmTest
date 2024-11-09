import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[10][9];
    static boolean[][] visited = new boolean[10][9];
    static int[] dx = {-3, -3, -2, -2, 2, 2, 3, 3};
    static int[] dy = {-2, 2, -3, 3, -3, 3, -2, 2};
    static int kingR, kingC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kingR = Integer.parseInt(st.nextToken());
        kingC = Integer.parseInt(st.nextToken());
        arr[kingR][kingC] = 1;

        System.out.println(BFS(r, c));
    }


    static int BFS(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new int[]{i, j, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int nowX = current[0];
            int nowY = current[1];
            int count = current[2];

            for (int k = 0; k < 8; k++) {
                int x = nowX + dx[k];
                int y = nowY + dy[k];

                if (x < 0 || x >= 10 || y < 0 || y >= 9) continue;
                if (!move(nowX, nowY, k)) continue;
                if (visited[x][y]) continue;
                if (x == kingR && y == kingC) return count + 1;

                visited[x][y] = true;
                q.add(new int[]{x, y, count + 1});
            }
        }
        return -1;
    }

    static boolean move(int i, int j, int tp) {
        int[][] dr = {
                {-1, -2}, {-1, -2}, {0, -1}, {0, -1}, {0, 1}, {0, 1}, {1, 2}, {1, 2}
        };
        int[][] dc = {
                {0, -1}, {0, 1}, {-1, -2}, {1, 2}, {-1, -2}, {1, 2}, {0, -1}, {0, 1}
        };

        for (int k = 0; k < 2; k++) {
            int r = i + dr[tp][k];
            int c = j + dc[tp][k];
            if (r == kingR && c == kingC) {
                return false;
            }
        }
        return true;
    }

}