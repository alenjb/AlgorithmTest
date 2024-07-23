import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception{
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long num = Long.parseLong(br.readLine());
		long result = num;
		
		
		for(int i=2; i<=(int)Math.sqrt(num); i++) {
			if(num % i == 0) { // 소인수이면
				result = result - result / i;
				while(num % i == 0) {
					num = num / i;
				}
			}
		}
		
		// 자기 자신도 나눠주기
		if(num > 1) result = result - result /num;

		bw.write(result+"\n");
		bw.flush();

	}

}
