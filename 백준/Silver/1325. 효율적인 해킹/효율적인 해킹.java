import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr;
	static int N, M;
	static int [] indegree;
	static boolean [] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 
		M = Integer.parseInt(st.nextToken());
		arr = new List[N+1];
		indegree = new int[N+1];		
		for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
		}
		
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			BFS(i);
		}
				
		
		int maxVal = 0;
		for(int i = 1; i <N+1; i++) {
			maxVal = Math.max(maxVal, indegree[i]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == maxVal) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
		
		
	}
	private static void BFS(int i) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(i);
		visited[i] = true;
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int n : arr[next]) {
				if(!visited[n]) {
					indegree[n]++;
					q.add(n);
					visited[n] = true;
				}
			}
			
		}
	}
}