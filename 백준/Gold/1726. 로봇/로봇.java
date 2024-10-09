import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][][] visited;  // 좌표와 방향
    static int M, N;
    static int[] dr = {0, 0, 0, 1, -1};  // 동, 서, 남, 북
    static int[] dc = {0, 1, -1, 0, 0};  // 동, 서, 남, 북\
    static int startR, startC, startD, goalR, goalC, goalD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken()) - 1;
        startC = Integer.parseInt(st.nextToken()) - 1;
        startD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        goalR = Integer.parseInt(st.nextToken()) - 1;
        goalC = Integer.parseInt(st.nextToken()) - 1;
        goalD = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N][5]; // 각 위치에서 4개의 방향별로
        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startR, startC, startD, 0));
        visited[startR][startC][startD] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 목표 위치와 방향에 도달하면
            if (current.r == goalR && current.c == goalC && current.d == goalD) {
                return current.cnt;
            }

            // 1,2,3칸 전진 가능
            for (int k = 1; k <= 3; k++) {
                int newR = current.r + dr[current.d] * k;
                int newC = current.c + dc[current.d] * k;

                // 못가는 경우
                if (newR < 0 || newR >= M || newC < 0 || newC >= N || arr[newR][newC] == 1) {
                    break;
                }

                // 새로운 위치에 같은 방향으로 방문 X
                if (!visited[newR][newC][current.d]) {
                    visited[newR][newC][current.d] = true;
                    queue.add(new Node(newR, newC, current.d, current.cnt + 1));
                }
            }

            // 현재 방향에서 좌우로 90도 회전
            int[] newDirections = turnDirections(current.d);
            for (int newD : newDirections) {
                if (!visited[current.r][current.c][newD]) {
                    visited[current.r][current.c][newD] = true;
                    queue.add(new Node(current.r, current.c, newD, current.cnt + 1));
                }
            }
        }
        return -1; 
    }

    // 좌우로 회전
    static int[] turnDirections(int direction) {
        if (direction == 1 || direction == 2) {
            return new int[]{3, 4};
        } else {
            return new int[]{1, 2};
        }
    }

    static class Node {
        int r, c, d, cnt;

        public Node(int r, int c, int d, int cnt) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }
    }
}