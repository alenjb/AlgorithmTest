import java.util.*;

public class Main {
    static int N;
    static char[][] map;
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> students = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.next().charAt(0);
                if (map[i][j] == 'T') {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j] == 'S') {
                    students.add(new int[]{i, j});
                } else if (map[i][j] == 'X') {
                    empty.add(new int[]{i, j});
                }
            }
        }

        // 빈공간 조합
        if (select3(0, 0, new int[3][2])) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean select3(int start, int count, int[][] obstacles) {
        if (count == 3) {
            // 3개의 장애물을 배치한 후 검사
            for (int i = 0; i < 3; i++) {
                int[] obstacle = obstacles[i];
                map[obstacle[0]][obstacle[1]] = 'O';
            }

            boolean result = true;
            for (int[] teacher : teachers) {
                if (find(teacher[0], teacher[1])) {
                    result = false;
                    break;
                }
            }

            // 원상복구
            for (int i = 0; i < 3; i++) {
                int[] obstacle = obstacles[i];
                map[obstacle[0]][obstacle[1]] = 'X';
            }

            return result;
        }

        for (int i = start; i < empty.size(); i++) {
            obstacles[count] = empty.get(i);
            if (select3(i + 1, count + 1, obstacles)) { // 다음 장애물 좌표 찾으러 넘기기
                return true;
            }
        }
        return false;
    }

    private static boolean find(int r, int c) {
        int[] dr = {0, -1, 1, 0};
        int[] dc = {-1, 0, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            while (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 'O') {
                if (map[nr][nc] == 'S') return true;
                nr = nr + dr[i];
                nc = nc + dc[i];
            }
        }
        return false;
    }
}