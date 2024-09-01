import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int [][] arr;
    static List<int[]> cores;
    static int coresSize, N, result, maxConnected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            cores = new ArrayList<>(); // 코어 리스트 초기화

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    arr[i][j] = now;
                    if (now == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                        cores.add(new int[]{i, j});
                    }
                }
            }

            result = Integer.MAX_VALUE;
            maxConnected = 0;
            coresSize = cores.size();

            DFS(0, 0, 0); // cnt, caseResult, connected
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void DFS(int cnt, int caseResult, int connected) {
        if (cnt == coresSize) {
            if (connected > maxConnected) {
                maxConnected = connected;
                result = caseResult;
            } else if (connected == maxConnected) {
                result = Math.min(result, caseResult);
            }
            return;
        }

        int r = cores.get(cnt)[0];
        int c = cores.get(cnt)[1];

        // 상
        int up = checkConnect(r, c, -1, 0);
        if (up >= 0) {
            connect(r, c, -1, 0, 2);
            DFS(cnt + 1, caseResult + up, connected + 1);
            connect(r, c, -1, 0, 0); // 복원
        }

        // 하
        int down = checkConnect(r, c, 1, 0);
        if (down >= 0) {
            connect(r, c, 1, 0, 2);
            DFS(cnt + 1, caseResult + down, connected + 1);
            connect(r, c, 1, 0, 0); // 복원
        }

        // 좌
        int left = checkConnect(r, c, 0, -1);
        if (left >= 0) {
            connect(r, c, 0, -1, 2);
            DFS(cnt + 1, caseResult + left, connected + 1);
            connect(r, c, 0, -1, 0); // 복원
        }

        // 우
        int right = checkConnect(r, c, 0, 1);
        if (right >= 0) {
            connect(r, c, 0, 1, 2);
            DFS(cnt + 1, caseResult + right, connected + 1);
            connect(r, c, 0, 1, 0); // 복원
        }

        // 연결하지 않고 넘기기
        DFS(cnt + 1, caseResult, connected);
    }

    static int checkConnect(int r, int c, int dr, int dc) {
        int length = 0;
        int nr = r + dr;
        int nc = c + dc;
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (arr[nr][nc] != 0) return -1; // 연결 불가능
            nr += dr;
            nc += dc;
            length++;
        }
        return length;
    }

    static void connect(int r, int c, int dr, int dc, int value) {
        int nr = r + dr;
        int nc = c + dc;
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            arr[nr][nc] = value;
            nr += dr;
            nc += dc;
        }
    }
}