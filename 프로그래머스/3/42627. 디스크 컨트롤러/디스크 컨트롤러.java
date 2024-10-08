import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int []> pq = new PriorityQueue<int []>(
            (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        int time = 0;
        int result = 0;
        int idx = 0;
        int count = 0;
        int length = jobs.length;
        
        while(count < length){
            while(idx < length && jobs[idx][0] <= time){
                pq.add(jobs[idx++]);
            }
            if(pq.isEmpty()) time = jobs[idx][0];
            else{
                int [] now = pq.poll();
                count++;
                time += now[1];
                result += time - now[0];
            }
        }
        
        return result / length;
        
    }
}