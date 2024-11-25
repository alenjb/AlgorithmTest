import java.util.*;

class Solution {
static List<Integer> [] arr;
static int answer = 0;
static int l;
    public int solution(int[] info, int[][] edges) {
        int l = info.length;
        arr = new List [18];
        for(int i=0; i<18; i++) arr[i] = new ArrayList<>();
        
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            arr[a].add(b);
        }
                
        find(info);
        
        return answer;
    }
    
    void find(int[] info){
        Queue<Node> q = new ArrayDeque<>();
        Set<Integer> s = new HashSet<Integer>(arr[0]);
        q.add(new Node(0, 0, s, 0));
        
        while(!q.isEmpty()){
            Node node = q.poll();
            if(info[node.now] == 0){
                node.sheep++;
            }else{
                node.wolf++;                
            }

            answer = Math.max(answer, node.sheep);

            if(node.sheep <= node.wolf) {
                answer = Math.max(answer, node.sheep-1);
                continue;
            }
            
            node.visited.addAll(arr[node.now]);
            for(int next : node.visited){
                Set<Integer> newVi = new HashSet<>(node.visited);
                newVi.remove(next);
                q.add(new Node (node.sheep, node.wolf, newVi, next));
                
            }
        }
        
    }
    static class Node{
    int sheep;
    int wolf;
    int now;
    Set<Integer> visited = new HashSet<>();
    
    public Node(int sheep, int wolf, Set<Integer> visited, int now){
        this.sheep = sheep;
        this.wolf = wolf;
        this.visited = visited;
        this.now = now;
    }
}
}

