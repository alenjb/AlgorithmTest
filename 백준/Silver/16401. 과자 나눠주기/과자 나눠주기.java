
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static int n;
	public static void main(String[] args) throws Exception{
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int [m];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		// 막대과자 길이 탐색
		int left = 1;
		int right = arr[m-1];
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2; 
			if(!check(mid)) right = mid -1;
			else if(check(mid)) left = mid +1;
		}
		bw.write(right+"");
		bw.flush();
	}
	static boolean check(int num) {
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			cnt += (arr[i] / num);
		}
		if(cnt >=n) return true;
		return false;
	}
}
