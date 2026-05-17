import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        // arr로 만들기
        List<Integer> [] arr = new List[n+1];
        for(int i=0; i<n+1; i++) arr[i] = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            arr[b].add(a);
            arr[a].add(b);
        }
        for(int cut=0; cut < wires.length; cut++){
            // 자르기
            int cutA = wires[cut][0];
            int cutB = wires[cut][1];
            arr[cutA].remove(Integer.valueOf(cutB));
            arr[cutB].remove(Integer.valueOf(cutA));
        
            // 잘린 두군데서 DFS 돌려서 세기
            boolean [] visited1 = new boolean[n+1];
            boolean [] visited2 = new boolean[n+1];
            visited1[cutA] = true;
            visited2[cutB] = true;
            int cntA = dfs(cutA, arr, visited1);
            int cntB = dfs(cutB, arr, visited2);
            if(Math.abs(cntA - cntB) < answer) answer = Math.abs(cntA - cntB);
            arr[cutA].add(cutB);
            arr[cutB].add(cutA);
        }
        return answer;
    }
    public int dfs(int num, List<Integer>[] arr, boolean[] visited){
        int count = 1;
        for(int next : arr[num]){
            if(!visited[next]){
                visited[next] = true;
                count+= dfs(next, arr, visited);
            }
        }
        return count;
        
    }
}