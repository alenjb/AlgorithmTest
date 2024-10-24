import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static int [][] map;
    static int [][] dist; // 거리 배열
    static int [] dr = {0, 1, -1, 0};
    static int [] dc = {-1, 0, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split("");

            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        BFS();
        System.out.println(dist[N-1][N-1]);

    }

    public static void BFS() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (check(nr, nc, r, c)) {
                    int newDist = dist[r][c];
                    if (map[nr][nc] == 0) {  // 검은색이면 +1
                        newDist += 1;
                    }

                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist; // 거리 업데이트
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static boolean check(int nr, int nc, int r, int c) {
        return nr >= 0 && nc >= 0 && nc < N && nr < N && dist[nr][nc] > dist[r][c];
    }

}