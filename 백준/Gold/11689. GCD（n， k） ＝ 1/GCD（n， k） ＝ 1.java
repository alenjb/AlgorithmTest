import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception{
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long num = Long.parseLong(br.readLine());	// 타겟 대상 수
		long result = num;	//타겟 대상 수와 서로소인 개수
		
		
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			if(num % i == 0) { // 타겟 대상의 소인수이면
				result = result - result / i; // 타겟 대상 수와 서로소인 개수 업데이트
				while(num % i == 0) { // 타겟 대상에서 해당 소수를 모두 제거
					num = num / i;
				}
			}
		}
		
		// num이 마지막 소인수인 경우 
		if(num > 1) result = result - result /num;

		bw.write(result+"\n");
		bw.flush();

	}

}
