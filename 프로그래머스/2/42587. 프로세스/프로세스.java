import java.util.*;
class Solution {
    public int solution(int[] pri, int location) {
        Queue<Node> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int l = pri.length;
        int find = pri[location];
        for(int i=0; i<l; i++){
            int num = pri[i];
            if(i == location) q.offer(new Node(num, true));
            else q.offer(new Node(num, false));
            pq.offer(num);
            
        }
        
        int max = -1;
        while(!q.isEmpty()){
            Node poll = q.poll();
            int qpoll = pq.poll();
            if(qpoll > poll.num) {
                q.offer(poll);
                pq.offer(qpoll);
            }
            // 우선순위가 똑같으면 그대로
            else {
                if(poll.is) return l - q.size();
            }
        }
        return 0;
    }
    static class Node{
        int num;
        boolean is;
        public Node(int n, boolean i){
            this.num = n;
            this.is = i;
        }
    }
}