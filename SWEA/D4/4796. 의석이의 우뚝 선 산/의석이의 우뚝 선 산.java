import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = scanner.nextInt();
        
        for(int tc=1; tc<=T; tc++) {
        	int N = scanner.nextInt();
        	long [] arr = new long [N];
        	int [] fixed = new int [N];        
        	int result = 0;
        	
        	for(int i=0; i<N; i++) arr[i] = scanner.nextLong();
        	
        	//배열 변경
        	fixed[0] = 1;
        	for(int i=1; i<N; i++) {
        		if(arr[i] > arr[i-1]) fixed[i] = 1;
        		else if(arr[i] < arr[i-1]) fixed[i] = -1;
        	}
        	
        	for(int i=1; i<N; i++) {
        		int up =0;
        		int down = 0;
        		int idx = i;
        		while(idx <N && fixed[idx]==1) {
        			idx++;
        			up++;
        		}
        		// idx -> 증가하고 떨어진 첫 인덱스
        		while(idx < N && fixed[idx]==-1) {
        			idx++;
        			down++;
        		}
        		
        		result += (up * down);
        		up = 0;
        		down = 0;
        		i = idx-1;
        	}
        	sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}