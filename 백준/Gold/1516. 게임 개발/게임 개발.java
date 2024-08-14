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
		int N = Integer.parseInt(st.nextToken());	// 건물의 개수
		int [] time = new int[N+1];
		int [] totalTime = new int[N+1];
		
		List<Integer>[] arr = new ArrayList[N+1];// 인접 리스트 
		int [] inDegree = new int[N+1];
		
		// 인접 리스트 초기화
		for(int i=0; i<N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 인접 리스트 및 진입 차수 배열 값 넣기
		for(int tc = 1; tc < N+1; tc++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken()); // 걸리는 시간
			time[tc] = w;
			totalTime[tc] =w;
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				arr[num].add(tc); //인접 리스트에 추가
				inDegree[tc]++; // 진입차수 배열 ++
			}
		}
				
		Queue<Integer> q = new LinkedList<>();
		
		// 진입 차수가 0인 것들은 q에 넣기
		for(int i=1; i<N+1; i++) {
			if(inDegree[i] == 0 ) {
				q.add(i);
			}
		}

		while(!q.isEmpty()) {
			int now = q.poll();
			for(int num : arr[now]) {
				inDegree[num]--;
				totalTime[num] = Math.max(totalTime[num], totalTime[now] + time[num]);
				if(inDegree[num] == 0) q.add(num);
			}
		}
		
		for(int i=1; i<N+1; i++) {
			sb.append(totalTime[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}