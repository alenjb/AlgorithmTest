import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int [][] arr = new int [500][500];
        for(int i=0; i<triangle[0].length; i++){
            arr[0][i] = triangle[0][i];            
        }
        
        for(int i=1; i<triangle.length; i++){
        //맨 왼쪽
            arr[i][0] = arr[i-1][0] + triangle[i][0];
        //맨 오른쪽
            arr[i][triangle[i].length-1] = arr[i-1][triangle[i].length-1] + triangle[i][triangle[i].length-1];
        }
        
        // 중간
        for(int i=1; i<triangle.length; i++){
            for(int j=1; j<triangle[i].length; j++){
                arr[i][j] = Math.max(arr[i-1][j-1] + triangle[i][j], arr[i-1][j] + triangle[i][j] ) ;
            }
        }
        
        int answer = 0;
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(answer, arr[triangle.length-1][i]);            
        }
        
        return answer;
    }
}