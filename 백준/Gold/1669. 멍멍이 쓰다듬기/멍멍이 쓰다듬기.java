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
		long x = Long.parseLong(st.nextToken()); 
		long y = Long.parseLong(st.nextToken()); 
		long result = 0;
		long value = y-x;
		
		int flag = 1;
		int count = 0;
		if(value == 0) {
			bw.write(0+"\n");
			bw.flush();
			bw.close();
			return;
		}
		for(int i=1; ;) {
			result +=i;
			count++;
			if(result >= value) {
				bw.write(count+"\n");
				bw.flush();
				bw.close();
				return;
			}
			flag = -flag;
			if(flag == 1) i++;
		}
	}
}
