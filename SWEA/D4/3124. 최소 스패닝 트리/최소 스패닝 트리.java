import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int [] parent;
    static int [][] arr;
    static int V, E;
    static PriorityQueue<Node7> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parent = new int[V+1];

            for(int i=1; i<=V; i++) parent[i] = i;

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                pq.add(new Node7(s,e,w));
            }

            int cnt = 0;
            long result = 0;
            while (cnt<V-1){
                Node7 poll = pq.poll();
                int rootS = find(poll.start);
                int rootE = find(poll.end);

                if(rootS != rootE) {
                    union(poll.start, poll.end);
                    result += poll.weight;
                    cnt++;
                }
            }
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb);

    }
    static void union (int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA ==  rootB) return;
        parent[rootB] = rootA;
    }
    static int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}

class Node7 implements Comparable<Node7>{
    int start;
    int end;
    int weight;

    public Node7(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node7 o) {
        return this.weight - o.weight;
    }
}