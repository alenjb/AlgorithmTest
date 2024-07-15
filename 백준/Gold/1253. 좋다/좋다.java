import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long [] arr;
	static int n;
	public static void main(String[] args) throws Exception{
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		// 2. 정렬하기
		Arrays.sort(arr);
		int cnt = 0;
		// 3. i=0부터 시작해서 n-1까지 반복하면서 arr[i]를 타겟으로 정하기
		for(int i=0; i<n; i++) {
			long target = arr[i];
			// 3-1. 0부터 n-1까지 반복하면서 (j!=i)일 때 (왼쪽 타겟 = j)
			outer : for(int j=0; j<n; j++) {
				if(j==i) continue;
				long find = arr[i] - arr[j];
				//3-2. arr[i] - arr[j]를 이분탐색으로 찾기
				
				int left = 0;
				int right = n-1;
				int mid = 0;
				while(left <= right) {
					mid = (left + right) / 2;
					if(arr[mid] == find && mid!=j&&mid!=i) {
						cnt++;
						break outer;
					}
					else if(arr[mid] > find) right = mid-1;
					else left = mid +1;
				}
			}
		}				
		bw.write(cnt + "\n");
		bw.flush();
	}	
}
