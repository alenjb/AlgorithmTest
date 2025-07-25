import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
		
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer> [] arr = new ArrayList[N+1];
		int [] in = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int tc=0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());	
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second);
			in[second]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<N+1; i++) {
			if(in[i] == 0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			for(int num : arr[now]) {
				in[num]--;
				if(in[num] == 0) q.add(num);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}