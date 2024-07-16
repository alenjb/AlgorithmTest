import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		for(int k=0; k<T; k++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Applicants [] apps = new Applicants[N];
			List<Applicants> list = new ArrayList<>();
			// 1. 입력받기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				apps[i] = new Applicants(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			//2. A 1등 삽입
			Arrays.sort(apps);
			
			int Bmin = Integer.MAX_VALUE;
			list.add(apps[0]);
			Bmin = apps[0].b;
			
			for(int i=1; i<N; i++) {
				// 다음 A 높은 사람
				Applicants next = apps[i];
				if(next.b < Bmin) {
					Bmin = next.b;
					list.add(next);
				}
			}
			bw.write(list.size() + "\n");			
		}
		bw.flush();
	}
	
	static class Applicants implements Comparable<Applicants>{
		int a, b;
		public Applicants(int a, int b) {
			this.a = a;
			this.b = b;
		}
		// a로 정렬 시
		public int compareTo(Applicants app) {
			return this.a - app.a; 
		}		
	}
}
