import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		int max = 1_000_001;
		int [] arr = new int [max];
		int maxVal = -1;
		int minVal = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<>(); // 입력받은 순서대로 저장
		
		// 입력 받기
		
		for(int i=0; i<total; i++) {
			int now = sc.nextInt();
			arr[now]++;
			if(now > maxVal) maxVal = now;
			if(now < minVal) minVal = now;
			list.add(now);
		}
				
		
		for(int i=0; i< total; i++) {
			int now = list.get(i);
			int count = 0;
			for(int j=1; j<= Math.sqrt(now); j++) {
				if(now % j == 0 ) { //소인수이면
					// 약수는 j와 now / j
					if(arr[j]!=0) count += arr[j]; // j에 대해 더하기
					if(j!= (now/j) && arr[now/j]!=0) count+=arr[now/j]; // now/j에 대해 더하기
				}
			}
			System.out.println(count - 1);
		}
	}
}
