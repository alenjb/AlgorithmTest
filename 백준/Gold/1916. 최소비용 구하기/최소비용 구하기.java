import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        List<Node> [] arr = new List[N+1];
        for(int i=1; i<=N; i++) arr[i] = new ArrayList<Node>();
        boolean [] visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 버스의 개수

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, weight));
        }

        int [] dijkstra = new int[N+1];
        for(int i=1; i<=N; i++) dijkstra[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra[start] = 0;

        pq.add(new Node(start,0));
        while (!pq.isEmpty()){
            Node poll = pq.poll();
            int weight = poll.weight;
            int now = poll.end;
            if(visited[now]) continue;
            visited[now] = true;

            for(int i=0; i<arr[now].size(); i++){
                Node nn = arr[now].get(i);
                int nextValue = nn.weight;
                int next = nn.end;
                if(dijkstra[next] > dijkstra[now] + nextValue){
                    dijkstra[next] = dijkstra[now] + nextValue;
                    pq.add(new Node(next, dijkstra[next]));
                }
            }
        }

        System.out.println(dijkstra[end]);



    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int e, int w){
            this.end = e;
            this.weight = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
