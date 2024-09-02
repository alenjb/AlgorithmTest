import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge> {
        int node, cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static int V, E, K;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> adj;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        V = Integer.parseInt(VE[0]);
        E = Integer.parseInt(VE[1]);
        K = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        visited = new boolean[V + 1];
        adj = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()); // start -> end
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Edge(end, cost)); // b로가는 가중치
        }

        pq.add(new Edge(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if(visited[current.node]) continue;
            visited[current.node] = true;
            for (Edge next : adj.get(current.node)) {
                if (dist[next.node] > dist[current.node] + next.cost) {
                    dist[next.node] = dist[current.node] + next.cost;
                    pq.add(new Edge(next.node, dist[next.node])); // 새로운 노드를 업데이트
                }
            }
        }


        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}