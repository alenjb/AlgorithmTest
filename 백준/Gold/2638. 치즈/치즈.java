import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int N, M, totalNum, time;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        time = 0;
        totalNum = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
                if (now == 1) totalNum++;
            }
        }

        while (totalNum > 0) { // 총 치즈 개수가 0보다 클 때까지만 반복
            visited = new boolean[N][M];
            time++;

            // 격자의 가장자리에서 DFS를 실행해 외부 공기 탐색
            for (int i=0; i<N; i++) {
                if (!visited[i][0] && arr[i][0] == 0) DFS(i, 0); // 왼쪽 가장자리
                if (!visited[i][M-1] && arr[i][M-1] == 0) DFS(i, M-1); // 오른쪽 가장자리
            }
            for (int j=0; j<M; j++) {
                if (!visited[0][j] && arr[0][j] == 0) DFS(0, j); // 위쪽 가장자리
                if (!visited[N-1][j] && arr[N-1][j] == 0) DFS(N-1, j); // 아래쪽 가장자리
            }
            play(); // 치즈 녹이기
        }

        System.out.println(time);
    }

    // 치즈가 녹는 걸 계산하는 함수
    static void play() {
        List<Pos> meltPositions = new ArrayList<>(); // 녹는 위치 저장
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (arr[i][j] == 0) continue;
                if (melt(i, j)) meltPositions.add(new Pos(i, j)); // 녹는 위치 추가
            }
        }
        
        for (Pos pos : meltPositions) {
            arr[pos.r][pos.c] = 0;
            totalNum--;
        }
    }

    // 치즈가 녹는지 확인하는 함수
    static boolean melt(int i, int j) {
        int cnt = 0;
        for (int d=0; d<4; d++) {
            int newR = i + dr[d];
            int newC = j + dc[d];

            if (check(newR, newC) && visited[newR][newC]) cnt++; // 외부 공기와 맞닿으면 카운트 증가
            if (cnt >= 2) return true;  // 2면 이상이 외부 공기와 맞닿아 있으면 true
        }
        return false;
    }

    // DFS로 외부 공기 탐색
    static void DFS(int r, int c) {
        visited[r][c] = true;  // 방문 처리
        for (int i=0; i<4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (check(newR, newC) && !visited[newR][newC] && arr[newR][newC] == 0) {
                DFS(newR, newC); // 외부 공기를 계속 탐색
            }
        }
    }

    // 격자 내 좌표 유효성 검사
    static boolean check(int r, int c) {
        return r>=0 && r<N && c >= 0 && c < M;
    }

    // 좌표를 저장하는 클래스
    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}