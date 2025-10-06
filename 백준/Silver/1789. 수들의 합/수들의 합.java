import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long S = sc.nextLong();
        // (n * (n+1)) / 2 = S
        // 2S = (n) * (n+1)

        long left = 0;
        long right = S+1;  // 최대로는 S까지 가능 (1 + 2 + ... + S > S)

        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if ((mid * (mid + 1)) / 2 <= S) {
                left = mid;   // 가능 → 더 크게 가본다
            } else {
                right = mid;  // 불가능 → 줄인다
            }
        }

        System.out.println(left);  // 최대 N


    }
}
