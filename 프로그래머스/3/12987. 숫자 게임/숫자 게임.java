// import java.util.*;
// class Solution {
//     public int solution(int[] A, int[] B) {
//         Arrays.sort(A);
//         Arrays.sort(B);
//         int answer = 0;
//         for(int i=0; i<A.length; i++){
//             // A[i] 보다 큰 것 중 제일 작은거 찾기
//             int idx = find(A[i], B);
//             if(idx >=0 && B[idx] > A[i]){
//                 B[idx] = -1;
//                 answer++;            
//             }
//         }
//         return answer;
//     }
//     public int find(int target, int[] B){
//         int left = 0;
//         int right = B.length-1;
//         while(left + 1 < right){
//             int mid = (left + right) / 2;
//             if(isValid(target, mid, B)) right = mid;
//             else left = mid;
//         }
//         return right;
//     }
//     public boolean isValid(int target, int num, int[] B){
//         return B[num] > target;
//     }
// }

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int j = 0; // B 배열 포인터

        for (int i = 0; i < A.length; i++) {
            while (j < B.length && B[j] <= A[i]) {
                j++; // A[i]보다 작거나 같은 B는 건너뜀
            }
            if (j < B.length) {
                answer++;
                j++; // 해당 B[j] 사용 처리
            }
        }

        return answer;
    }
}
