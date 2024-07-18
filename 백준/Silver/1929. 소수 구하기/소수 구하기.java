import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N+1];
        
        for(int i=2; i<=N; i++) {
        	arr[i] = i; 
        }
        
        for(int i=2; i<=Math.sqrt(N); i++) {
        	if(arr[i] == -1) continue;
        	for(int j= i+i; j<=N; j=j+i) {
        		arr[j] = 0;
        	}
        }
        for(int i=M; i<=N; i++) {
        	if(arr[i]!=0) bw.write(arr[i]+"\n");
        }
        
        bw.flush();
	}

}
