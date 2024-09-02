import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][] arr;
    static boolean[] visited;
    static long result = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        visited[0] = true;  // 출발점을 0번 도시로 고정
        dfs(0, 0, 0, 1);  // 도시 0에서 시작

        System.out.println(result);
    }

    private static void dfs(int start, int now, long cost, int count) {
        if (count == N) {
            if (arr[now][start] != 0) {  // 마지막 도시에서 시작 도시로 돌아갈 수 있는 경우
                result = Math.min(result, cost + arr[now][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && arr[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + arr[now][i], count + 1);
                visited[i] = false;
            }
        }
    }
}