import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] init;
    static int[][] copy;
    static int N, M, result;
    static List<int[]> twos = new ArrayList<>(); // 2가 있는 위치의 배열들
    static List<List<int[]>> selects = new ArrayList<>(); // 조합들
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 선택할 수
        init = new char[N][N];
        result = Integer.MAX_VALUE;

        int cnt = 0; // 빈 칸 수 세기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char num = st.nextToken().charAt(0);
                if (num == '1') init[i][j] = '-'; // 1은 -로 표시
                else if (num == '2') init[i][j] = '+'; // 2를 +로 표시
                else init[i][j] = num;
                if (num == '0') cnt++; // 빈 칸 개수 세기
                if (num == '2') twos.add(new int[]{i, j});
            }
        }

        // 빈 칸이 없으면 결과는 0
        if (cnt == 0) {
            System.out.println(0);
            return;
        }

        List<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < twos.size(); i++) idxs.add(i);
        select(new ArrayList<>(), 0); // 조합 만들기

        // 각각 BFS 돌리기
        for (List<int[]> list : selects) {
            // copy 배열 초기화
            copy = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (init[i][j] == '-') copy[i][j] = -1; // 벽은 -1
                    else copy[i][j] = -2; // 빈 칸과 바이러스 칸 구분 : -2는 탐색X
                }
            }

            Queue<int[]> q = new ArrayDeque<>();
            for (int[] pos : list) {
                q.add(pos);
                copy[pos[0]][pos[1]] = 0; // 바이러스 위치는 0
            }

            int bfsMax = BFS(q, cnt);
            if (bfsMax != Integer.MAX_VALUE) result = Math.min(result, bfsMax);
        }

        //출력 하기
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // 선택된 바이러스들에 대해 조합을 만드는 함수
    static void select(List<int[]> selected, int start) {
        if (selected.size() == M) {
            selects.add(new ArrayList<>(selected));
            return;
        }

        for (int i = start; i < twos.size(); i++) {
            selected.add(twos.get(i));
            select(selected, i + 1); // 다음 선택을 위한 재귀 호출
            selected.remove(selected.size() - 1); // 선택 해제
        }
    }

    static int BFS(Queue<int[]> q, int tmp) {
        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                for (int j = 0; j < 4; j++) {
                    int newR = poll[0] + dr[j];
                    int newC = poll[1] + dc[j];
                    if (check(new int[]{newR, newC})) {
                        copy[newR][newC] = copy[poll[0]][poll[1]] + 1;
                        q.add(new int[]{newR, newC});
                        time = Math.max(time, copy[newR][newC]);

                        if (init[newR][newC] == '0') tmp--;
                        if (tmp == 0) return time;
                    }
                }
            }
        }

        return tmp == 0 ? time : Integer.MAX_VALUE;
    }

    static boolean check(int[] pos) {
        int r = pos[0];
        int c = pos[1];
        return r >= 0 && r < N && c >= 0 && c < N && copy[r][c] == -2 && init[r][c] != '-';
    }
}