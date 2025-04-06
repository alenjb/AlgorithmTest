import java.util.*;
class Solution {
    static boolean [] visited;
    static List<Integer> [] arr;
    public int solution(int n, int[][] com) {
        arr = new List[n+1];
        visited = new boolean[n+1];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && com[i][j] == 1){
                    arr[i].add(j);
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                DFS(i);
                answer++;
            }
        }
        return answer;
    }
    public void DFS(int num){
        visited[num] = true;
        for(int con : arr[num]){
            if(!visited[con]) DFS(con);
        }
    }
}