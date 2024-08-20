import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int [5001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int cnt = 1;
        arr[3] =1;
        arr[5] = 1;
        for(int i=6; i<=N; i++){
            if(arr[i-3] == Integer.MAX_VALUE &&  arr[i-5] == Integer.MAX_VALUE ) continue;
            arr[i] = Integer.min(arr[i-3], arr[i-5])+1;
        }
        if(arr[N] == Integer.MAX_VALUE) sb.append(-1);
        else sb.append(arr[N]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}