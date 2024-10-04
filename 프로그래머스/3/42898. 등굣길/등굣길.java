import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int [][] dp = new int[n+1][m+1];
        // 가로 채우기
        int minfirst = Integer.MAX_VALUE;
        for(int i=0; i<puddles.length; i++){
            if(puddles[i][1] == 1) minfirst = Math.min(minfirst, puddles[i][0]-1);
        }
        minfirst = Math.min(minfirst, m);
        
        for(int i=0; i<minfirst; i++){
            dp[0][i] = 1;
        }
        //세로 채우기
        minfirst = Integer.MAX_VALUE;
        for(int i=0; i<puddles.length; i++){
            if(puddles[i][0] == 1) minfirst = Math.min(minfirst, puddles[i][1]-1);
        }
        minfirst = Math.min(minfirst, n);
        for(int i=0; i<minfirst; i++){
            dp[i][0] = 1;
        }


        //dp
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(inPuddles(i, j, puddles)) dp[i][j] = 0;
                else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;            
            }
        }
        
        int answer = dp[n-1][m-1] % 1000000007;
        return answer;
    }
    
    static boolean inPuddles(int i, int j, int [][] puddles){
        for(int ii=0; ii<puddles.length; ii++){
            if(puddles[ii][0] -1 == j && puddles[ii][1] -1 == i) return true;
        }
        return false;
    }
}