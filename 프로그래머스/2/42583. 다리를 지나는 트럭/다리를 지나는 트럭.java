import java.util.*;

class Solution {
    public int solution(int bl, int w, int[] truck_weights) {
        Queue<Node> on = new ArrayDeque<>();
        int onW = 0;
        Queue<Node> before = new ArrayDeque<>();
        int time = 0;
        int after = 0;

        for(int tt : truck_weights){
            before.add(new Node(tt, 0));
        }

        while(after != truck_weights.length){
            time++;

            // 다리 위 트럭들 이동 처리
            int size = on.size();
            for(int i = 0; i < size; i++){
                Node n = on.poll();
                n.t++;
                if(n.t >= bl){
                    onW -= n.num;
                    after++;
                } else {
                    on.add(n);
                }
            }

            // 트럭 추가 여부 검사
            if(!before.isEmpty()) {
                Node now2 = before.peek();
                if(on.size() < bl && onW + now2.num <= w) {
                    Node now = before.poll();
                    on.add(now);
                    onW += now.num;
                }
            }
        }

        return time;
    }

    static class Node{
        int num;
        int t; // 머문 시간
        public Node(int n, int t){
            this.num = n;
            this.t = t;
        }
    }
}
