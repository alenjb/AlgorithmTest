import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int [][] arr, arr2;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int small = Math.min(N, M);
		arr = new int[N][M];
		arr2 = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}		
		
		for(int k=0; k<R; k++) {
			for(int i=0, minY=0, maxY=N-1, minX=0, maxX= M-1; 
					i<= (small%2 == 0? small/2-1 : small/2); 
					i++, minX++, minY++, maxX--, maxY--) {
				rotate(minY, maxY, minX, maxX);
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = arr2[i][j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

		
	}
	
	// 0, M-1부터 시작
	// 0~ 짝수면 N/2-1 홀수면 N/2
	// N-2 ~ (N-1) - N/2
	static void rotate(int minY, int maxY, int minX, int maxX) {
		if(minX == maxX) {
			arr2[minY][minX] = arr[minY][minX];
			return;
		}
		
		// 위쪽
		for(int i=maxX-1; i>=minX; i--) {
			arr2[minY][i] = arr[minY][i+1];
		}
			
		// 왼쪽 아래로
		for(int i=minY+1; i<= maxY; i++) {
			arr2[i][minX] = arr[i-1][minX];
		}
		
		// 아래쪽
		for(int i=minX+1; i<= maxX; i++) {
			arr2[maxY][i] = arr[maxY][i-1];
		}
				
		// 오른쪽 위로
		for(int i=maxY-1; i>= minY; i--) {
			arr2[i][maxX] = arr[i+1][maxX];
		}
	}
}