import java.util.*;
class Solution {
    static public int ans = 0;
    public int solution(int[] numbers, int target) {
        int l = numbers.length;
        DFS(numbers, target, 0, 0);
        return ans;
    }
    static void DFS(int [] numbers, int target, int idx, int sum){
        if(idx == numbers.length){
            if(sum == target) ans++;
            return;
        }
        // 덧셈
        DFS(numbers, target, idx+1, sum + numbers[idx]);
        // 뺄셈
        DFS(numbers, target, idx+1, sum - numbers[idx]);
    }
}