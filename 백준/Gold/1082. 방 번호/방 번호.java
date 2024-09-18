import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int minCost = Integer.MAX_VALUE;
    static int minCostIdx = -1;
    static int secondMinCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 숫자 종류
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            if (minCost > cost[i]) {
                minCost = cost[i];
                minCostIdx = i;
            }
            if (i != 0) {
                secondMinCost = Math.min(secondMinCost, cost[i]);
            }
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 예산

        // 최대 자리수 구하기
        int maxDigit = M / minCost;

        // 첫 번째 자리가 0이 아닌 숫자가 되도록 예산 고려
        if (minCostIdx == 0 && maxDigit > 0) {
            // 0으로 시작할 수 없기 때문에 두 번째로 싼 숫자 사용
            maxDigit = (M - secondMinCost) / minCost + 1;
        }

        // 예산으로 최소한 한 자리라도 만들 수 있을 때
        if (maxDigit > 0) {
            int[] result = new int[maxDigit];
            Arrays.fill(result, minCostIdx);

            int remainCost = M - (maxDigit * minCost);

            for (int j = N - 1; j > 0; j--) {
                if (remainCost + minCost >= cost[j]) {
                    result[0] = j;
                    remainCost = remainCost + minCost - cost[j];
                    break;
                }
            }

            for (int i = 1; i < maxDigit; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (remainCost >= cost[j] - minCost) {
                        result[i] = j;
                        remainCost -= (cost[j] - minCost);
                        break;
                    }
                }
            }

            for (int i = 0; i < result.length; i++) {
                sb.append(result[i]);
            }
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}