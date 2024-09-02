import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] arr;
    static List<int[]> perms = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        // 순열 만들기
        List<Integer> poss = new ArrayList<>();
        for (int i = 0; i < N; i++) poss.add(i);
        permutation(0, new int[N], poss);

        long result = Long.MAX_VALUE;

        // 순열에서 빼서 계산하기
        for (int[] nows : perms) {
            long tmpResult = 0;
            boolean valid = true;

            for (int k = 0; k < N - 1; k++) {
                int start = nows[k];
                int end = nows[k + 1];
                if (arr[start][end] == 0) {
                    valid = false; // 이동할 수 없는 경로가 존재하는 경우
                    break;
                }
                tmpResult += arr[start][end];
            }

            if (valid && arr[nows[N - 1]][nows[0]] != 0) { // 마지막에서 첫 번째 도시로 돌아가는 경로가 있는지 확인
                tmpResult += arr[nows[N - 1]][nows[0]];
                result = Math.min(result, tmpResult);
            }
        }

        System.out.println(result);
    }

    private static void permutation(int cnt, int[] now, List<Integer> remain) {
        if (cnt == N) {
            perms.add(now.clone());
            return;
        }
        for (int i = 0; i < remain.size(); i++) {
            int num = remain.get(i);
            now[cnt] = num;
            remain.remove(i);
            permutation(cnt + 1, now, remain);
            remain.add(i, num);  // 원상태로 복구
        }
    }
}