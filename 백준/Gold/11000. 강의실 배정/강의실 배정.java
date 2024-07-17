import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Class> pq = new PriorityQueue<>(
				(o1, o2) -> {
		            // 시작시간 오름차순 정렬, 시작시간 같다면 종료시간 오름차순 정렬
		            if (o1.end == o2.end) {
		                return o1.start - o2.start;
		            } else {
		                return o1.end - o2.end;
		            }
		        });
		int N = Integer.parseInt(st.nextToken());
		Class [] arr = new Class[N];
		// 입력 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Class(start, end);
		}
		// 정렬하기
		Arrays.sort(arr);
		// 첫번째 요소 넣기
		pq.offer(arr[0]);
		
		for(int i=1; i<N; i++) {
			Class now = pq.peek();
			int nowEnd = now.end;
			if(nowEnd <= arr[i].start) pq.poll();
			pq.offer(arr[i]);
		}
		bw.write(pq.size()+"\n");
		bw.flush();
	}
	static class Class implements Comparable<Class>{
		int start, end;
		public Class(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public int compareTo(Class c) {
			if(this.start == c.start) return this.end - c.end;
			return this.start - c.start;
		}
	}
}
