import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄 읽기
		
		int x1 = Integer.parseInt(st.nextToken()); // 주어지는 사각형을 이루는  사각형 중 제일 왼쪽 아래 1칸짜리 사각형의 x인덱스(0부터 시작)
		int y1 = Integer.parseInt(st.nextToken()); // 주어지는 사각형을 이루는  사각형 중 제일 왼쪽 아래 1칸짜리 사각형의 y인덱스(0부터 시작)
		int x2 = Integer.parseInt(st.nextToken()) -1; // 주어지는 사각형을 이루는  사각형 중 제일 오른쪽 위  1칸짜리 사각형의 x인덱스(0부터 시작)
		int y2 = Integer.parseInt(st.nextToken()) -1; // 주어지는 사각형을 이루는  사각형 중 제일 오른쪽 위  1칸짜리 사각형의 y인덱스(0부터 시작)
		
		int min = Math.min(x1, y1); //탐색을 위한 최소값
		int max = Math.max(x2, y2); // 탐색을 위한 최대값
		
		long result = 0; //최종 결과 long으로 해야함

		for(int i=min; i<=max; i++) { //최소부터 최대 까지 탐색
			if(i % 2 == 1) { // 인덱스가 홀수번째이면(홀수 번째이면 색칠됨)
				int column = 0; // 세로
				int row = 0; // 가로
				
				// 세로 계산
				if(i>= x1 && i<= x2 && i >= y1) { // 가로의 범위 안에 있고 세로의 최소범위보다 크면
					int tmp = Math.min(i, y2);
					if(tmp>0) column = tmp - y1 +1;	// 양수개인 경우만 더하기
				}
				
				// 가로 계산
				if(i>= y1 && i<= y2 && i >= x1) { // 세로의 범위 안에 있고 가로의 최소범위보다 크면
					int tmp = Math.min(i, x2);
					if(tmp>0) row = tmp - x1 +1; // 양수개인 경우만 더하기		
				}
				
				//중복 제거
				if(row >0 && column>0) result--; // 만약 가로에서도 계산하고 세로에서도 계산하면 두번 계산하므로 1개 빼주기
				// 결과 업데이트
				result = result + row + column;							
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
