import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 노드의 개수
        int E = Integer.parseInt(st.nextToken()); // 엣지의 개수
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발 노드
        
        // 인접 리스트 만들기
        List<Node>[] arr = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        
        // 엣지 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 노드
            int v = Integer.parseInt(st.nextToken()); // 도착 노드
            int w = Integer.parseInt(st.nextToken()); // 가중치
            arr[u].add(new Node(v, w));
        }
        
        // 최단거리 배열
        long [] D = new long [V+1];
        boolean [] visited = new boolean[V+1];
        for(int i=0; i<V+1; i++) D[i] = Long.MAX_VALUE;
        D[start] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int)(o1.weight - o2.weight));
        
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
        	Node node = pq.poll();
        	if(visited[node.vertex]) continue; //이미 방문했었으면 안가기
        	visited[node.vertex] = true;
        	for(Node n : arr[node.vertex]) {
        		if(D[n.vertex] > (D[node.vertex] + n.weight)) {
        			D[n.vertex] = D[node.vertex] + n.weight;
        			pq.add(new Node(n.vertex, D[n.vertex]));
        		}
        	}
        }
        
        for(int i=1; i<V+1; i++) {
        	if(D[i] == Long.MAX_VALUE) sb.append("INF\n");
        	else sb.append(D[i]+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
	}
}
class Node {
    int vertex;
    long weight;
    
    public Node(int vertex, long weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
 }