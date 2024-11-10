import java.util.*;
import java.io.*;

public class Main {
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};
    static int n, left, right, result, mid;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        left = -1;
        right = 1_000_000_000;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        result = right;

        // 이진 탐색
        while (left +1< right) {
            mid = (left + right) / 2;
            if (BFS()) {
                right = mid;
            } else {
                left = mid;
            }
        }
        result = right;

        System.out.println(result);
    }

    // 가능하면 true 반환
    static boolean BFS() {
        visited = new boolean[n][n];
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int r = current.r;
            int c = current.c;

            if (r == n - 1 && c == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (check(newR, newC) && Math.abs(map[r][c] - map[newR][newC]) <= mid) {
                    visited[newR][newC] = true;
                    queue.offer(new Node(newR, newC));
                }
            }
        }
        return false;
    }

    static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n && !visited[r][c];
    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}