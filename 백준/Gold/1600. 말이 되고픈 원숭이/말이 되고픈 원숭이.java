import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int K, W, H;
    static int[][] map;
    static int[][][] visited;
    static int[] dr1 = {0, 1, -1, 0};
    static int[] dc1 = {-1, 0, 0, 1};
    static int[] dr2 = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dc2 = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H][W];
        visited = new int[H][W][K+1];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
                Arrays.fill(visited[i][j], Integer.MAX_VALUE); // 초기화
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = 0;

        while (!q.isEmpty()) {
            Node poll = q.poll();

            if (poll.r == H - 1 && poll.c == W - 1) {
                System.out.println(poll.count);
                return;
            }

            // 일반 이동
            for (int i = 0; i < 4; i++) {
                int newR = poll.r + dr1[i];
                int newC = poll.c + dc1[i];
                if (check(newR, newC) && map[newR][newC] == 0 && visited[newR][newC][poll.jump] > poll.count + 1) {
                    visited[newR][newC][poll.jump] = poll.count + 1;
                    q.add(new Node(newR, newC, poll.count + 1, poll.jump));
                }
            }

            // 말처럼 이동 (점프)
            if (poll.jump < K) {
                for (int i = 0; i < 8; i++) {
                    int newR = poll.r + dr2[i];
                    int newC = poll.c + dc2[i];
                    if (check(newR, newC) && map[newR][newC] == 0 && visited[newR][newC][poll.jump + 1] > poll.count + 1) {
                        visited[newR][newC][poll.jump + 1] = poll.count + 1;
                        q.add(new Node(newR, newC, poll.count + 1, poll.jump + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static boolean check(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W && map[r][c]!= 1;
    }

    static class Node {
        int r;
        int c;
        int count;
        int jump;

        public Node(int r, int c, int count, int jump) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.jump = jump;
        }
    }
}