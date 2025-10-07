import java.util.*;
class Solution {
    static int [] parent;
    public int solution(int n, int[][] wires) {
        parent = new int [n+1];
        int answer = Integer.MAX_VALUE;
        // 모든 간선에 대해서
        for(int line = 0; line<n; line++){
            // 부모배열 초기화
            for(int i=1; i<=n; i++) parent[i] = i;
            for(int j=0; j<n-1 ;j++){
                if(line == j) continue;
                union(wires[j][0], wires[j][1]);
            }
            // 모든 부모에 대해서 find
            int p = find(1);
            int num1 = 1;
            for(int j=2; j<=n; j++){
                if(find(j) == p) num1++;
            }
            int num2 = n - num1;
            answer = Math.min(answer, Math.abs(num2-num1));
        }        
        return answer;
    }
    static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
    
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        
        if(aa!=bb){
            parent[aa] = bb;
        }
        
    }
}