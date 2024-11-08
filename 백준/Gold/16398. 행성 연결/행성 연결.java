import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][] map;
    static int [] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            return Long.compare(o1.cost, o2.cost);
        }
    });
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++) parent[i] = i;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i>j){
                    pq.add(new Edge(i, j, map[i][j]));
                }
            }
        }

        int total = 0;
        long totalCost = 0;
        while (total<N-1 && !pq.isEmpty()){
            Edge poll = pq.poll();
            int start = poll.start;
            int end = poll.end;
            if(find(start)!= find(end)) {
                union(start, end);
                totalCost += poll.cost;
                total++;
            }
        }

        System.out.println(totalCost);

    }
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);

        if(aa!= bb){
            parent[aa] = bb;
        }
    }
    static int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }

    static class Edge{
        int start;
        int end;
        long cost;

        public Edge(int start, int end, long cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}