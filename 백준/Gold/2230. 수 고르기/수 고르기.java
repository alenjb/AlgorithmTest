import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int answer = Integer.MAX_VALUE;
        int left = 0, right = 0;

        while (left < N && right < N) {
            int diff = arr[right] - arr[left];

            if (diff < M) {
                right++;
            } else {
                answer = Math.min(answer, diff);
                left++;
            }
        }

        System.out.println(answer);
    }
}
