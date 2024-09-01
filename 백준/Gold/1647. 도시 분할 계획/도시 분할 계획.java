import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        int cnt = 0;
        long result = 0;
        int maxWeight = 0;

        while (cnt < N - 1 && !pq.isEmpty()) {
            Node poll = pq.poll();
            if (find(poll.s) != find(poll.e)) {
                union(poll.s, poll.e);
                result += poll.w;
                if(cnt==N-2) maxWeight = poll.w;
                cnt++;
            }
        }

        // 두 마을로 분리하기 위해 가장 큰 간선의 가중치를 뺌
        System.out.println(result - maxWeight);
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);
        if (aa != bb) parent[aa] = bb;
    }

    static int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    static class Node implements Comparable<Node> {
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}