import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		
		// 1. 입력 받기
		int test = Integer.parseInt(st.nextToken());
		for(int i=0; i< test; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 2. 최대 공약수 구하기(유클리드 호제법)
			int num = euclid(a, b);
			
			// 3. 최소 공배수 구하기(A * B / 최대공약수)
			int result = a * b / num;
			bw.write(result+"\n");	
		}
		bw.flush();
		
		
	}
	static int euclid(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		
		int result = max % min;
		if(result == 0 ) return min;
		return euclid(min, result);
	}
}
