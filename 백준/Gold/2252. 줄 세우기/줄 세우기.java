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
		int N = Integer.parseInt(st.nextToken());	// 학생의 수
		int M = Integer.parseInt(st.nextToken());	//키를 비교한 횟수
		
		List<Integer> [] arr = new ArrayList[N+1]; // 인접 리스트
		int [] in = new int[N+1];	// 진입 차수 배열
		
		//인접리스트 초기화
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int tc=0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());	
			int second = Integer.parseInt(st.nextToken());
			arr[first].add(second); // 인접리스트에 추가
			in[second]++; //진입 차수 증가
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