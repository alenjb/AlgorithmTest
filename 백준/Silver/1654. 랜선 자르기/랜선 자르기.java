import java.util.*;

public class Main {
    static int[] arr;
    static int K, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        arr = new int[K];
        long max = -1;

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }

    public static boolean check(long num) {
        long total = 0;
        for (int i = 0; i < K; i++) {
            total += arr[i] / num;
        }
        return total >= N;
    }
}
