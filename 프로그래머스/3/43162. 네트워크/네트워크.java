import java.util.*;
class Solution {
    static int [] parent;
    public int solution(int n, int[][] computers) {
        // 부모 초기화
        parent = new int [n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int r = computers.length;
        int c = computers[0].length;
        
        // 입력값으로 유니온
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(i!=j && computers[i][j] == 1){
                    union(i, j);
                }
            }
        }
        
        //parent의 값들 셋에 넣기
        Set<Integer> set = new HashSet<>();
        for(int num : parent) set.add(find(num));
        return set.size();
        
        
    }
    
    public void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa!= bb) parent[aa] = bb;
    }
    
    public int find(int a){
        int p = parent[a];
        if(p == a) return a;
        return parent[a] = find(p);
    }
}