import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        int count = 0;
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= A[start++];
            } else if (end == N) {
                break;
            } else {
                sum += A[end++];
            }

            if (sum == M) count++;
        }

        System.out.println(count);
    }
}
