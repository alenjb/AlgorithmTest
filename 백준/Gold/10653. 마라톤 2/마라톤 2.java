import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 개수
        int K = Integer.parseInt(st.nextToken()); // 건너뛸 개수

        int[][] dp = new int[K + 1][N]; // dp 배열
        int[][] dist = new int[N][N]; // 거리
        int[][] pos = new int[N][2]; // 좌표들 (x, y)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken()); // x
            pos[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        // 거리 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 자기 자신은 거리 0
                } else {
                    dist[i][j] = Math.abs(pos[i][0] - pos[j][0]) + Math.abs(pos[i][1] - pos[j][1]);
                }
            }
        }

        // DP 배열 초기화
        //dp[i][j] = 최대 i개를 건너뛰고 j에 도착했을 때의 최소 거리
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0; // 출발점에서 출발점으로

        // DP 계산
        for (int i = 1; i < N; i++) { // 목적지
            for (int j = 0; j <= K; j++) { // 건너뛸 수 있는 개수
                for (int k = 0; k <= j; k++) { // 마지막에 건너뛸 개수
                    if (i - k - 1 >= 0 && dp[j - k][i - k - 1] != Integer.MAX_VALUE) { // i-k-1 = 목적지 이전 마지막 위치, (목적지 이전의 마지막 위치는 0번째보다 큼 && 목적지 전 마지막 위치까지 뛰어넘어서 얻은 최단 거리가 초기화 되었으면)
                        dp[j][i] = Math.min(dp[j][i], dp[j - k][i - k - 1] + dist[i - k - 1][i]);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
            result = Math.min(result, dp[i][N - 1]);
        }

        System.out.println(result);
    }
}