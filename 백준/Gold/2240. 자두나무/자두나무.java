import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, W;
    static int[] input;
    static int[][][] dp; // 시간, 움직임, 현재 위치

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        input = new int[T + 1];
        dp = new int[T + 1][W + 1][3];

        // 입력 처리
        for (int i = 1; i <= T; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        // 1초
        if (input[1] == 1) {
            dp[1][0][1] = 1;  // 자두가 1번 나무에서 떨어지면 받는다.
        } else {
            dp[1][1][2] = 1;  // 자두가 2번 나무에서 떨어지면 이동 후 받는다.
        }

        // 2초 이상
        for (int t = 2; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 1번 나무에서 떨어질 때
                if (input[t] == 1) {
                    dp[t][w][1] = dp[t - 1][w][1] + 1;  // 직전이 1번 나무인 경우
                    if (w > 0) { // 움직임이 없으면 1번에 계속 있으니까
                        dp[t][w][1] = Math.max(dp[t][w][1], dp[t - 1][w - 1][2] + 1);  // 직전이 2번 나무인데 1번으로 온 경우
                    }
                    dp[t][w][2] = dp[t - 1][w][2];  // 직적이 2번이고 지금도 2번인 경우
                }

                // 2번 나무에서 떨어질 때
                else {
                    dp[t][w][2] = dp[t - 1][w][2] + 1;  // 직전이 2번 나무인 경우
                    if (w > 0) { // 움직임이 없으면 1번에 계속 있으니까
                        dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w - 1][1] + 1);  // 직전이 1번 나무인데 2번으로 온 경우
                    }
                    dp[t][w][1] = dp[t - 1][w][1];  // 직전이 1번이고 지금도 1번인 경우
                }
            }
        }

        int result = 0;

        for (int w = 0; w <= W; w++) {
            result = Math.max(result, Math.max(dp[T][w][1], dp[T][w][2]));
        }

        System.out.print(result);
    }
}