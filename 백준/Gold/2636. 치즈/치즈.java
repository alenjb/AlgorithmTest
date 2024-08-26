import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int remain;  // 남은 치즈조각
    static boolean[][] visited;
    static int[] dx ={-1, 0, 0, 1};
    static int[] dy ={0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    remain++;
                }
            }
        }

        int count = 0;  // 걸린 시간
        int result = 0; // 모두 녹기 한 시간 전에 남아있는 치즈조각
        while(remain > 0) {
            visited = new boolean[N][M];  // 새로운 탐색을 위해 초기화
            count++;
            int before = remain;
            dfs(0, 0);
            if(remain == 0) {   // 모두 녹았으면 한 시간 전에 남아있는 치즈조각을 result에 저장
                result = before;
            }
        }
        System.out.println(count+"\n"+result);
    }

    // 치즈를 녹이기 위한 dfs
    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(check(ny, nx) && arr[ny][nx] == 1) {  // 공기 주변에 치즈가 있는 경우
                // 치즈조각을 녹이고 해당 자리를 방문처리
                // 방문처리를 안하게 되면 원래 공기가 있는 곳으로 생각하여 dfs를 진행
                remain--;
                arr[ny][nx] = 0;
                visited[ny][nx] = true;
            }
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 방문하지 않은 곳 중 공기이면 DFS
            if(check(ny, nx) && !visited[ny][nx] && arr[ny][nx] == 0) {
                dfs(ny, nx);
            }
        }
    }

    public static boolean check(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }

}