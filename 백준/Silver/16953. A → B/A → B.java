import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//16953번
public class Main {
	static int n;
	static int m;
	public static void main(String[] args) throws Exception{
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Queue<A> q = new LinkedList<>();
		int result = Integer.MAX_VALUE;
		q.add(new A(n,0));
		while(!q.isEmpty()) {
			A a = q.poll();
			long p = a.num;
			int d = a.depth;
			if(p == m && result > d) result = d;
			else if( p < m) {
				q.add(new A(p*2, d+1));
				q.add(new A(p*10 +1, d+1));
			}
		}
		if(result == Integer.MAX_VALUE) bw.write("-1");
		else	bw.write((result+1)+"\n");
		bw.flush();
	}
	static class A{
		long num;
		int depth;
		A(long num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
}
