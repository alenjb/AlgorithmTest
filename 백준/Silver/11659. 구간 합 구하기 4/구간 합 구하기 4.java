import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
		
        int [] arr = new int [N+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<N+1; i++) {
        	int now = Integer.parseInt(st.nextToken());;
        	arr[i]= arr[i-1] + now;
        	
        }
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int result = arr[end] - arr[start-1];
            sb.append(result).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        
	}
}