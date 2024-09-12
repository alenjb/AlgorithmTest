import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;
            
            // 왼쪽 방향 계산
            double maxLeftSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double)(arr[i] - arr[j]) / (i - j);
                if (slope < maxLeftSlope) {
                    maxLeftSlope = slope;
                    count++;
                }
            }

            // 오른쪽 방향 계산
            double maxRightSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double)(arr[j] - arr[i]) / (j - i);
                if (slope > maxRightSlope) {
                    maxRightSlope = slope;
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}