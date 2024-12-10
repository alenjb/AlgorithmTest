import java.util.*;

class Solution {
    static int [] parent;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(
        new Comparator<Edge>(){
            public int compare(Edge a, Edge b){
                return Integer.compare(a.cost, b.cost);
            }
        }
    );
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int [n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        
        for(int i=0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];
            pq.add(new Edge(a, b, cost));
        }
        
        int num = 0;
        while(num < n-1){
            Edge e = pq.poll();
            if(find(e.a)!= find(e.b)){
                union(e.a, e.b);
                answer+=e.cost;
                num++;
            }
        }
        
        
        return answer;
    }
    
    static void union (int a, int b){
        int aa = find(a);        
        int bb = find(b);
        if(aa!=bb) parent[aa] = bb;
    }
    
    static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
    
    static class Edge{
        int a;
        int b;
        int cost;
        
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
    
}