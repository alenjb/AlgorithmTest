import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] indegree;
	static List<Integer>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		indegree= new int [N+1];
		arr = new List[N+1];
		for(int i=1; i<=N; i++) arr[i] = new ArrayList<Integer>();
		
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for(int n: arr[now]) {
				indegree[n] --;
				if(indegree[n] == 0) q.add(n);
			}
		}
		
		System.out.println(sb);
	}

}