import java.util.*;
class Solution {
    public int solution(int[] pr, int loc) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = pr.length;
        int answer = 1;

        for(int num : pr) pq.add(num);
        
        while(!pq.isEmpty()){
            for(int i=0; i<n; i++){
                if(pq.peek() == pr[i]){
                    if(i == loc){
                        return answer;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }        
        return answer;
    }
}