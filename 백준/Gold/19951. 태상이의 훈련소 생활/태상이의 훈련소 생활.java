import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 연병장 길이
        int M = Integer.parseInt(st.nextToken()); // 작업 개수

        int[] arr = new int[N+1]; // 연병장 배열
        int[] sum = new int[N+1]; // 누적합 배열

        st = new StringTokenizer(br.readLine());

        // 연병장 입력 받기
        for(int i=1; i<N+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 작업 입력 받기
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sum[start] += weight;
            if (end + 1 <= N) {
                sum[end + 1] -= weight;
            }
        }
        
        // 누적합 적용하기
        for(int i=1; i<=N; i++) {
            sum[i] += sum[i-1];
            sb.append((arr[i] + sum[i])).append(" ");
        }
        
        
        bw.write(sb.toString().trim()); // 마지막 공백 제거
        bw.flush();
        bw.close();
    }
}
