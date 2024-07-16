import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = Integer.parseInt(st.nextToken());
		// 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			pq.offer(num);
		}
		long result = 0;
		while(pq.size() >=2) {
			int small1 = pq.poll();
			int small2 = pq.poll();
			int sum = small1 + small2;
			result += sum;
			pq.offer(sum);
		}
		bw.write(result+"\n");
		bw.flush();
	}
}
