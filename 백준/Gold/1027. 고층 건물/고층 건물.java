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
            int cnt = 0;

            // 왼쪽 방향 계산
            double ls = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double now = (double)(arr[i] - arr[j]) / (i - j);
                if (now < ls) {
                    ls = now;
                    cnt++;
                }
            }

            // 오른쪽 방향 계산
            double rs = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double now = (double)(arr[j] - arr[i]) / (j - i);
                if (now > rs) {
                    rs = now;
                    cnt++;
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}