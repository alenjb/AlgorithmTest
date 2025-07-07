import java.util.*;

public class Main {
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int r, c;
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int maxDistance = 0;

        // 모든 육지에서 BFS 실행
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    // 시작 좌표에서 BFS
    static int bfs(int startR, int startC) {
        boolean[][] visited = new boolean[r][c];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(new Pos(startR, startC, 0));
        visited[startR][startC] = true;

        int max = 0;

        while (!q.isEmpty()) {
            Pos now = q.poll();
            max = Math.max(max, now.cnt);

            for (int k = 0; k < 4; k++) {
                int newR = now.r + dr[k];
                int newC = now.c + dc[k];

                if (newR < 0 || newR >= r || newC < 0 || newC >= c) continue;
                if (visited[newR][newC] || arr[newR][newC] != 'L') continue;

                visited[newR][newC] = true;
                q.add(new Pos(newR, newC, now.cnt + 1));
            }
        }

        return max;
    }

    static class Pos {
        int r, c, cnt;

        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
