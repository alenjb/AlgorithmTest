import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        // A와 B를 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int l = A.length;
        int i = l-1; //aIdx
        int j = l-1; //bIdx
        int answer = 0;

        
        while(i>=0 && j>=0){
        // A idx와 b idx를 두고 
            // a[i] < b[j] 이면 a-- b-- answer++
            if(A[i] < B[j]){
                i--;
                j--;
                answer++;
            }else if(A[i] >= B[j]){
            // a[i] >= b[j] 이면 i--
                i--;
            } 
        }
        return answer;
    }
}