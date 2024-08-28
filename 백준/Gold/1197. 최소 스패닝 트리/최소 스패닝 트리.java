import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static PriorityQueue<Node> list;
	static int [] parent;

	public static void main(String[] args) throws Exception{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new PriorityQueue<>();
		parent = new int[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new Node(s, e, w));
		}

		// 유니온 파인드 배열 초기화
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		int cnt = 0;
		while(cnt<V-1){
			Node node = list.poll();
			int a = find(node.s);
			int b = find(node.e);
			if(a == b) continue;
			union(node.s, node.e);
			result += node.w;
			cnt++;
		}

		System.out.println(result);

	}
	
	static void union(int a, int b) {
		int aa = find(a);
		int bb = find(b);
		if(aa == bb) return;
		parent[aa] = find(bb);
	}
	
	static int find(int num) {
		if(parent[num] == num) return num;
		return parent[num] = find(parent[num]);
	}
}
class Node implements Comparable<Node>{
	int s;
	int e;
	int w;
	@Override
	public int compareTo(Node o) {
		return w - o.w;
	}
	public Node(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}
	
}