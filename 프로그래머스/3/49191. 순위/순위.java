import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        //n : 선수의 수
        int l = results.length;
        // l: 결과의 수
        Set<Integer> [] up = new Set [n+1]; 
        Set<Integer> [] down = new Set [n+1]; 
        
        for(int i=0; i<n+1; i++){
            up[i] = new HashSet<>();
            down[i] = new HashSet<>();
        }
        
        for(int i=0;i <l; i++){
            int winner = results[i][0];
            int loser = results[i][1];
            
            down[winner].add(loser);
            up[loser].add(winner);
            
        }
        
        for (int k = 1; k <= n; k++) { // 중간선수
            for (int i = 1; i <= n; i++) { // 시작선수
                if (down[i].contains(k)) {
                    down[i].addAll(down[k]);
                }
                if (up[i].contains(k)) {
                    up[i].addAll(up[k]);
                }
            }
        }

        
        int answer = 0;
        for(int i=0; i<n+1; i++){
            if((up[i].size() + down[i].size()) == n-1) answer++;
        }
        
        return answer;

    }
}