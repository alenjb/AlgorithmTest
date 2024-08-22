import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static int [][] arr;
    static int [] dx = {-1, 0, 0, 1};
    static int [] dy = {0, 1, -1, 0};
    static int [] max;
    static int [][] loc; //0행은 i 1행은 j
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            arr = new int [N][N];
            max = new int [N * N +1];
            loc = new int[2][N* N +1];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int now = Integer.parseInt(st.nextToken());
                    arr[i][j] = now;
                    loc[0][now] = i;
                    loc[1][now] = j;
                }
            }

            Arrays.fill(max, 1);
            max[N] = 1;
            for(int i=N*N; i>=1; i--) {
                move(N, loc[1][i], loc[0][i], 1);
            }

            int maxVal = -1;
            int maxX = -1;
            int maxY = -1;
            for(int i=N*N; i>=0; i--) {
                if(max[i] >= maxVal) {
                    maxVal = max[i];
                    maxX = loc[1][i];
                    maxY = loc[0][i];
                }
            }
            sb.append("#").append(tc).append(" ").append(arr[maxY][maxX]).append(" ").append(maxVal).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void move(int N, int x, int y, int depth) {
        for(int i=0; i<4; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];

            if(newX>=0 && newX <N && newY >=0 && newY <N && arr[y][x] +1 == arr[newY][newX]) { //현재 방향 이동 가능이면
                int now = arr[y][x];
                if(now!=N*N) max[now] = Math.max(depth + max[now+1], max[now]);
                return;
//				move(N, newX, newY, depth+1);
            }
        }
    }
}