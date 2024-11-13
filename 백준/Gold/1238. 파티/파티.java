import java.util.*;

public class Main {
    static int N, M, X;
    static int [][] dist;
    static int [] totalDist;
    static List<Node>[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        arr = new List[N+1];
        dist = new int [N+1][N+1];
        totalDist = new int[N+1];

        for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            arr[start].add(new Node(end, cost));
        }
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++){
                if(i!=j){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=1; i<=N; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()){
                Node poll = pq.poll();
                int next = poll.next;
                int cost = poll.cost;

                for(Node nn : arr[next]){
                    if(dist[i][nn.next] > dist[i][next] + nn.cost){
                        dist[i][nn.next] = dist[i][next] + nn.cost;
                        pq.add(new Node(nn.next, dist[i][next] + nn.cost));
                    }
                }
            }
            totalDist[i] += dist[i][X];
        }

        for(int i=1; i<=N; i++){
            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cost - o2.cost;
                }
            });
            pq.add(new Node(X, 0));
            while (!pq.isEmpty()){
                Node poll = pq.poll();
                int next = poll.next;
                int cost = poll.cost;

                for(Node nn : arr[next]){
                    if(dist[i][nn.next] > dist[i][next] + nn.cost){
                        dist[i][nn.next] = dist[i][next] + nn.cost;
                        pq.add(new Node(nn.next, dist[i][next] + nn.cost));
                    }
                }
            }
            totalDist[i] += dist[X][i];
        }

        int max = -1;
        for(int Num : totalDist){
            max = Math.max(max, Num);
        }
        System.out.println(max);

    }
    static class Node{
        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}