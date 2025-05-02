import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();  // 입력 자체가 정렬되어 있음
        for (int i = 0; i < M; i++) B[i] = sc.nextInt();

        int idx1 = 0;
        int idx2 = 0;

        StringBuilder sb = new StringBuilder();

        while (idx1 < N && idx2 < M) {
            if (A[idx1] <= B[idx2]) {
                sb.append(A[idx1++]).append(" ");
            } else {
                sb.append(B[idx2++]).append(" ");
            }
        }

        while (idx1 < N) sb.append(A[idx1++]).append(" ");
        while (idx2 < M) sb.append(B[idx2++]).append(" ");

        System.out.println(sb);
    }
}
