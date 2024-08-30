import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static List<Node10> [] arr;
    static boolean [] visited;
    static PriorityQueue<Node10> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            arr = new List[V+1];
            for(int i=1; i<=V; i++) arr[i] = new ArrayList<>();
            visited = new boolean[V+1];

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                Node10 node1 = new Node10(s, e, w);
                Node10 node2 = new Node10(e, s, w);
                arr[s].add(node1);
                arr[e].add(node2);
            }

            for(Node10 n : arr[1]){
                pq.add(n);
            }
            visited[1] = true;

            int cnt = 0;
            long result = 0;
            while (cnt < V-1){
                Node10 poll = pq.poll();
                if(visited[poll.e])continue;
                cnt++;
                visited[poll.e] = true;
                result+=poll.w;

                for(Node10 n : arr[poll.e]){
                    pq.add(n);
                }
            }
            pq.clear();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
    }
}
class Node10 implements Comparable<Node10>{
    int s;
    int e;
    int w;

    @Override
    public int compareTo(Node10 o){
        return Integer.compare(w, o.w);
    }

    public Node10(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}