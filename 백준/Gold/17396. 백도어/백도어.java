import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Node>[] arr;
    static boolean[] available;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 분기점 수
        M = Integer.parseInt(st.nextToken()); // 길의 수

        // 초기화
        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        arr = new List[N];
        available = new boolean[N];
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int seen = Integer.parseInt(st.nextToken());
            available[i] = (seen == 0) || (i == N - 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (available[a] && available[b]) {
                arr[a].add(new Node(b, w));
                arr[b].add(new Node(a, w));
            }
        }

        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (dist[poll.end] < poll.weight) continue;

            for (Node node : arr[poll.end]) {
                if (dist[node.end] > dist[poll.end] + node.weight) {
                    dist[node.end] = dist[poll.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }

        long result = dist[N - 1];
        if (result == Long.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(weight, o.weight);
        }
    }
}