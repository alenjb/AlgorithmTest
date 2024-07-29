import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int max = Integer.MIN_VALUE;
			for(int j=0; j<10; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp > max) max = tmp;
			}
			sb.append("#" + (i+1) + " " + max + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}