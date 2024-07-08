import java.util.*;
import java.io.*;

class Main {
    public static int [][] arr;
    public static boolean [][] visited;
    static int w;
    static int h;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w + h ==0) break;
            arr = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(arr[i][j] == 1 && !visited[i][j]){
                        dfs(j,i);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }
        bw.flush();
    }

    public static void dfs(int x, int y){
        int [] dx = {-1, 0, 0, 1, -1, -1, 1, 1};
        int [] dy = {0, -1, 1, 0, -1, 1, -1, 1};
        visited[y][x] = true;
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (check(nx, ny) && arr[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(nx, ny);
            }
        }

    }
    public static boolean check(int x, int y){
        return x >= 0 && w > x && y >= 0 && h > y;
    }
}
