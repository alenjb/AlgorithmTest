import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int sc : scoville) pq.add((long)sc);
        int answer = 0;
        while(pq.size() >=2){
            long a = pq.poll();
            if(a< K) {
                long b = pq.poll();
                pq.add(a+b*2);
                answer++;
            }
           else return answer;
        }
        if(pq.poll() >= K) return answer;
        return -1;
    }
}