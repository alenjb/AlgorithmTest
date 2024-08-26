import java.io.*;
import java.util.*;

public class Solution {
    static int n, num;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            num = 0;
            n = Integer.parseInt(br.readLine());
            arr = new char[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            calculate();

            // 미방문 세기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] == '.') {
                        num++;
                    }
                }
            }

            // 결과 출력
            sb.append("#").append(tc).append(" ").append(num).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    
    // 8칸에 모두 지뢰가 없는지 확인
    static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[nx][ny] == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    static void calculate() {
        // 주위 8칸에 지뢰가 없는 빈 칸을 찾음
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == '.' && check(i, j)) {
                    num++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});

                    // BFS
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        int x = pos[0];
                        int y = pos[1];
                        visited[x][y] = true;

                        for (int k = 0; k < 8; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && arr[nx][ny] == '.') {
                                visited[nx][ny] = true;
                                if (check(nx, ny)) { // 주위 8칸에 지뢰가 없는 곳
                                    q.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}