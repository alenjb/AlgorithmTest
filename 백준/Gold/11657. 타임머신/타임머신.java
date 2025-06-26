import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 노드 수
        int M = sc.nextInt(); // 간선 수

        Edge[] arr = new Edge[M];
        long[] dist = new long[N + 1]; // int → long

        Arrays.fill(dist, Long.MAX_VALUE); // int → long
        dist[1] = 0; // 시작 노드

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();
            arr[i] = new Edge(s, e, w);
        }

        // N-1번 반복
        for (int i = 1; i < N; i++) {
            for (Edge e : arr) {
                if (dist[e.s] != Long.MAX_VALUE && dist[e.s] + e.w < dist[e.e]) {
                    dist[e.e] = dist[e.s] + e.w;
                }
            }
        }

        // 음수 사이클 검사
        for (Edge e : arr) {
            if (dist[e.s] != Long.MAX_VALUE && dist[e.s] + e.w < dist[e.e]) {
                System.out.println("-1");
                return;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Long.MAX_VALUE) System.out.println("-1");
            else System.out.println(dist[i]);
        }
    }

    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
