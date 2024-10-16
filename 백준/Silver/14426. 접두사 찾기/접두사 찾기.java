import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int N, M, result;
    static String[] target, part;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 문자열 개수
        M = sc.nextInt(); // 검사해야하는 문자열
        target = new String[N];
        part = new String[M];
        result = 0;

        for (int i = 0; i < N; i++) target[i] = sc.next();
        for (int i = 0; i < M; i++) part[i] = sc.next();

        Arrays.sort(target);

        for (int i = 0; i < part.length; i++) {
            String p = part[i];
            bs(0, target.length - 1, p);
        }

        System.out.println(result);
    }

    static void bs(int start, int end, String p) {
        while (start <= end) {
            int mid = (start + end) / 2;
            String tar = target[mid];

            // 접두사 검사를 먼저 처리
            if (tar.startsWith(p)) {
                result++; // 접두사를 찾았으므로 결과값을 증가
                return;
            }

            // 이진 탐색의 일반적인 방식으로 탐색 범위 조정
            if (p.compareTo(tar) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }
}