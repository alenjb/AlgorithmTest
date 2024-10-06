import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [][] arr;
    static int n, m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;
        int[][] dp = new int[n][m]; // dp[i][j] = [i][j]를 오른쪽 밑 꼭짓점으로 하는 정사각형의 한 변 길이 최대값
        arr = new int[n][m];


        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = line.charAt(j) - '0';
                if(arr[i][j] == 1) result = 1;
            }
        }

        for(int i = 0; i < n; i++) dp[i][0] = arr[i][0];
        for(int j = 0; j < m; j++) dp[0][j] = arr[0][j];

        // DP 진행
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(arr[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        System.out.println(result * result);
    }
}