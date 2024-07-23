import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long result = euclid(a, b);
		for(int i=0; i<result; i++) {
			bw.write("1");			
		}
		bw.flush();
		
		
	}
	static long euclid(long a, long b){
		long max = Math.max(a, b);
		long min = Math.min(a, b);
		long result = max % min;
		
		if(result ==0L) return min;
		return euclid(min, result);
	}
}
