import java.util.*;

public class Main {
    static int N, E, resultFirst, resultSecond, firstNum, secondNum;
    static List<Node> [] arr;
    static int INF = 200000001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        arr = new List[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            arr[s].add(new Node(e, d));
            arr[e].add(new Node(s, d));  // 양방향 추가
        }

        firstNum = sc.nextInt();
        secondNum = sc.nextInt();

        resultFirst = 0;
        resultSecond = 0;

        // 1 - f - s- n
        resultFirst = dijkstra(1, firstNum);
        if(resultFirst >= INF) resultFirst = INF;
        else {
            resultFirst += dijkstra(firstNum, secondNum);
            if(resultFirst >= INF) resultFirst = INF;
            else resultFirst += dijkstra(secondNum, N);
        }

        // 1- s - f- n
        resultSecond = dijkstra(1, secondNum);
        if(resultSecond >= INF) resultSecond = INF;
        else {
            resultSecond += dijkstra(secondNum, firstNum);
            if(resultSecond >= INF) resultSecond = INF;
            else resultSecond += dijkstra(firstNum, N);
        }

        if (resultFirst >= INF && resultSecond >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(resultFirst, resultSecond));
        }
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.end;

            if (visited[now]) continue;

            visited[now] = true;

            for (Node next : arr[now]) {
                if (dist[next.end] > dist[now] + next.dist) {
                    dist[next.end] = dist[now] + next.dist;
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end;
        int dist;

        public Node(int end, int dist) {
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}