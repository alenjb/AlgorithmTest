import java.util.*;
class Solution {
    static int [] parent;
    public int solution(int n, int[][] computers) {
        parent = new int [n];
        for(int i=0; i<n; i++) parent[i] = i;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(find(i));
        }
        return set.size();
    }
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        
        if(aa!=bb){
            parent[aa] = bb;
        }
    }
    
    static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
}