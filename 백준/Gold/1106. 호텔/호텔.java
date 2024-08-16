import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 입력 받기
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 목표 인원 수
        int N = Integer.parseInt(st.nextToken()); // 도시 수
        int[] cost = new int[N];
        int[] value = new int[N];

        long[] dp = new long[C + 100];
        Arrays.fill(dp, Long.MAX_VALUE);

        // dp[0]을 0으로 초기화
        dp[0] = 0;

        // 비용과 인원 데이터 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 비용
            int v = Integer.parseInt(st.nextToken()); // 모집 가능한 인원 수
            cost[i] = c;
            value[i] = v;

            // DP 배열 채우기
            for (int j = v; j < C + 100; j++) {
                if(dp[j-v] != Long.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j - v] + c);
                }
            }
        }

        // 답 찾기
        long min = Long.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            min = Math.min(dp[i], min);
        }

        // 출력
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }
}