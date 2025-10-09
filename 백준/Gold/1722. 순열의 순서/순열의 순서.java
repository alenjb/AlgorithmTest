import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int check = sc.nextInt();

        if (check == 1) {
            long K = sc.nextLong(); // 몇 번째 순열을 출력할지
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= N; i++) nums.add(i);

            long[] fact = new long[N + 1];
            fact[0] = 1;
            for (int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i;

            K--; // 인덱스 0부터 계산하기 위해

            for (int i = N; i >= 1; i--) {
                long idx = K / fact[i - 1];
                K %= fact[i - 1];

                System.out.print(nums.get((int) idx) + " ");
                nums.remove((int) idx);
            }
        } else {
            int[] perm = new int[N];
            for (int i = 0; i < N; i++) perm[i] = sc.nextInt();

            boolean[] visited = new boolean[N + 1];
            long answer = 0;

            for (int i = 0; i < N; i++) {
                int now = perm[i];
                int smaller = 0;

                for (int j = 1; j < now; j++) {
                    if (!visited[j]) smaller++;
                }

                answer += smaller * factorial(N - i - 1);
                visited[now] = true;
            }

            System.out.println(answer + 1);
        }
    }

    public static long factorial(long n) {
        long ans = 1;
        for (long i = 1; i <= n; i++) ans *= i;
        return ans;
    }
}
