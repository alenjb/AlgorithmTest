import java.util.*;
class Solution {
    public int solution(int[][] t) {
        int l = t.length;
        int [][] answer = new int [l][l];
        answer[0][0] = t[0][0];
        if(l == 1) return t[0][0];
        
        answer[1][0] = t[0][0] + t[1][0];
        answer[1][1] = t[0][0] + t[1][1];
        
        // 양끝
        for(int i=1; i<l; i++) answer[i][0] = answer[i-1][0] + t[i][0];
        for(int i=1; i<l; i++) answer[i][i] = answer[i-1][i-1] + t[i][i];
        
        //a[i][j] 는 Max(a[i-1][j-1], [i-1][j]) + a[i][j] 로부터 나옴
        for(int i=1; i<l; i++){
            for(int j=1; j<=i; j++){
                answer[i][j] = Math.max(answer[i-1][j-1], answer[i-1][j]) + t[i][j];
            }
        }
        
        int sum = -1;
        for(int i=0; i<l; i++){
            sum = Math.max(sum, answer[l-1][i]);
            // System.out.println(answer[l-1][i]);
        }
        return sum;
    }
}