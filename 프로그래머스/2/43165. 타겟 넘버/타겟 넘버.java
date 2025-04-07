import java.util.*;
class Solution {
    static int answer = 0;
    static int l;
    public int solution(int[] numbers, int target) {
        l = numbers.length;
        BFS(0, numbers, target, 0);
        return answer;
    }
    
    // BFS
    public void BFS(int sum, int[] numbers, int target, int idx){        
        if(idx == l){ // 길이가 맞으면
            if(sum == target) answer++;
            return;
        }

        BFS(sum - numbers[idx], numbers, target, idx+1);
        BFS(sum + numbers[idx], numbers, target, idx+1);
    }
    
}