import java.util.*;
class Solution {
    int [] parent;
    public int solution(int n, int[][] computers) {
        parent = new int [n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        for(int i=0; i<n; i++) parent[i] = find(parent[i]);
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(parent[i]);
        
        int answer = set.size();
        return answer;
    }
    
    public void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        parent[aa] = bb;
    }
    
    public int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}