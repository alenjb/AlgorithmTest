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
        
        for(int i=0; i<=N; i++) {
        	arr[i] = i; 
        }
        
        for(int i=2; i<=N; i++) {
        	if(i<=N && M<=i && arr[i]!=-1) bw.write(arr[i]+"\n");
        	for(int j=i; j<=N; j= j+i) {
        		arr[j] = -1;
        	}
        	
        }
        
        bw.flush();
	}

}
