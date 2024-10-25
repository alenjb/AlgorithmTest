import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int div = 1000000007;
        int n = sc.nextInt();
        long [][] dp = new long[2][n + 1]; // 0행은 dp, 1행은 더한 값들

        dp[0][1] = 2;
        dp[1][1] = 0;
        if (n >= 2) {
            dp[0][2] = 7;
            dp[1][2] = 1;
        }

        for (int i = 3; i <= n; i++) {
            dp[0][i] = (dp[0][i-1] * 2 % div
                    + dp[0][i-2] * 3 % div
                    + dp[0][i-3] * 2 % div
                    + 2 * dp[1][i-1] % div) % div;

            dp[1][i] = (dp[1][i-1] + dp[0][i-3]) % div;
        }

        System.out.println(dp[0][n]);
    }
}