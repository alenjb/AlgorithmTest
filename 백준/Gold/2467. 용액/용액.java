
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> arr;
	public static void main(String[] args) throws Exception{
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		int distance = Integer.MAX_VALUE;
		int firstNum = 0;
		int secondNum = 0;
		
		
		//각 수의 -를 붙여서 
		// i : 첫번째 용액의 인덱스
		for(int i=0; i<n-1; i++) {
			int left = i+1;
			int right = n-1;
			while(left <= right) {
				int mid = (left + right) / 2;
				int sum = Math.abs(arr.get(i) + arr.get(mid));
				
				if(distance > sum) {
					distance = sum;
					firstNum = arr.get(i);
					secondNum = arr.get(mid);
					
				}
				// 찾았을 때
				if(arr.get(mid) < -arr.get(i)) {
					left = mid +1;
				}else {
					right = mid-1;
				}
			}
//			System.out.println("left: "+ left +" right: "+right);
			
		}
		
		bw.write(firstNum + " " + secondNum +"\n");
		bw.flush();
		
	}	
}
