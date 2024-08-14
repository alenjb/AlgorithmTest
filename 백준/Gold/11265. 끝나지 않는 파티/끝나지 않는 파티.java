import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
	
	
		//1 입력 받기
		
		// 1-1. N과 M 입력 받기
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	 // 파티장의 개수(1~)
		int M = Integer.parseInt(st.nextToken());	// 사람 수 (1~)
		
		long [][] arr = new long [N+1][N+1];
		
		// 자기 자신은 0으로 초기화하고 나머지는 -1로 초기화
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) arr[i][j] = 0;
				else arr[i][j] = -1;
			}
		}
		
		// 각 거리 입력 받기
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				arr[i][j] = Long.parseLong(st.nextToken());
			}
		}
		
		//플로이드워셜로 거리 배열 업데이트
		for(int k=1; k<=N; k++) {	// K
			for(int s=1; s<=N; s++) {	// S
				for(int e=1; e<=N; e++) {	// E
					arr[s][e] = Math.min(arr[s][e], arr[s][k] + arr[k][e]);
				}				
			}
		}
		
		//손님들에 따라 가능한지 여부 출력하기
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long limitTime = Long.parseLong(st.nextToken());
			
			if(limitTime >= arr[start][end]) { //시간 안에 가는 경우
				sb.append("Enjoy other party\n");
			}else { //시간 안에 못가는 경우
				sb.append("Stay here\n");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}