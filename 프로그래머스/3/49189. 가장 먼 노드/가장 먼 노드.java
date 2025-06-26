import java.util.*;
class Solution {
    //BFS
    public int solution(int n, int[][] edge) {

        int r = edge.length;
        int c = edge[0].length;
    
        List<Integer> [] arr = new List[n+1];
        boolean [] visited = new boolean [n+1];
        for(int i=1; i<=n; i++) arr[i] = new ArrayList<>();
        for(int i=0; i<r; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        int max = 0;
        Set<Integer> set = new HashSet<>();
        
        //bfs
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        visited[1] = true;
        
        while(!q.isEmpty()){
            Node poll = q.poll();
            if(poll.cnt > max){
                set = new HashSet<>();
                set.add(poll.num);
                max = poll.cnt;
            }else if(poll.cnt == max){
                set.add(poll.num);   
            }
                
            for(int next : arr[poll.num]){
                if(!visited[next]) {
                    q.add(new Node(next, poll.cnt+1));
                    visited[next] = true;
                }
            }
        }
        return set.size();
    }
    
    static class Node{
        int num;
        int cnt;
        
        public Node(int n, int c){
            num = n;
            cnt = c;
        }
    }
}