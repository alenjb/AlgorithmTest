import java.io.*;
import java.util.*;

class Point {
    int x, y, cnt;

    Point(int x, int y) {
        this(x, y, 0);
    }

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            // 시작점, 도착점 입력
            Point[] points = new Point[2];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            sb.append(bfs(points, N)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(Point[] points, int N) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(points[0]);
        visited[points[0].x][points[0].y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == points[1].x && p.y == points[1].y) {
                return p.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Point(nx, ny, p.cnt + 1));
            }
        }

        return -1;
    }
}
