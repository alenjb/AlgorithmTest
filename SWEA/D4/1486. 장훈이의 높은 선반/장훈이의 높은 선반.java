import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int[] heights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            
            int result = solve(heights, B);
            
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static int solve(int[] heights, int B) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; //처음은 true로 하기
        
        for (int height : heights) {
            for (int j = sum; j >= height; j--) { // 한번만 검사하기 위해서 거꾸로 하기(오름차로 하면 같은 수를 중복으로 계속 더할 수 있게되므로)
            	if (dp[j - height]) {
            	    dp[j] = true;
            	}
            }
        }
        
        for (int i = B; i <= sum; i++) {
            if (dp[i]) return i - B;
        }
        
        return -1;
    }
}