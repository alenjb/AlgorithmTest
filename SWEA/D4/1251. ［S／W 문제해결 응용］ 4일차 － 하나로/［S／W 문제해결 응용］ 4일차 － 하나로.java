import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int [] xPos, yPos;
    static List<Node> [] arr;
    static int N;
    static boolean [] visited;
    static double E;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            xPos = new int[N];
            yPos = new int[N];
            arr = new List[N+1];
            visited = new boolean[N+1];

            for(int i=0; i<=N; i++) arr[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) xPos[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) yPos[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            E = Double.parseDouble(st.nextToken());

            for (int i=0; i<N; i++){ // i: start 노드 (yPos[i] xPos[i])
                for(int j= i+1; j<N; j++){ // j: end 노드의 (yPos[j] xPos[j])
                    int x1 = xPos[i];
                    int y1 = yPos[i];
                    int x2 = xPos[j];
                    int y2 = yPos[j];

                    double cost = (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)) * E;
                    arr[i].add(new Node(i, j, cost));
                    arr[j].add(new Node(j, i, cost));
                }
            }
            pq.add(new Node(0, 0, 0));
            int cnt = 0;
            double result = 0;

            while (cnt <= N-1){
                Node poll = pq.poll();
                if(visited[poll.e]) continue;
                visited[poll.e] = true;
                cnt++;
                result += poll.w;
                for(Node next : arr[poll.e]) pq.add(next);
            }
            pq.clear();
            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
        }
        System.out.print(sb);
    }

    static class Node implements Comparable<Node>{
        int s;
        int e;
        double w;

        public Node(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.w, o.w);
        }
    }
}