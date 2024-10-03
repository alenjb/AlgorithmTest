import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int len = prices.length;
        int[] answer = new int [len];
        int idx = 0;
        
        pq.add(new Node(0, prices[0]));
        for(int i=1; i< prices.length; i++) {
            pq.add(new Node(i, prices[i]));
            int dist = prices[i] - prices[i-1];//i-1에서 i까지의 증감 
            while(dist <0 &&!pq.isEmpty()&& pq.peek().price > prices[i] 
                  && pq.peek().num < i){// 작아졌으면
                Node n = pq.poll();
                answer[n.num] = i - n.num;
            }    
        }
        while(!pq.isEmpty()){
            Node n = pq.poll();
            answer[n.num] = len-1 - n.num;
        }
        
        return answer;
    }
}

class Node implements Comparable<Node>{
    int num;
    int price;
    
    public Node(int n, int p){
        this.num = n;
        this.price = p;
    }
    
    public int compareTo(Node n){
        return n.price - this.price;
    }
}
