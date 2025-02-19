import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 작업별로 100% 달성까지 남은 일수를 계산하여 큐에 저장
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int days = (remaining % speeds[i] == 0) ? remaining / speeds[i] : (remaining / speeds[i]) + 1;
            queue.offer(days);
        }
        
        List<Integer> result = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int count = 1;
            int first = queue.poll(); // 첫 번째 작업의 완료 예상 일수
            
            // 첫 번째 작업과 같은 날 배포할 수 있는 작업 개수 계산
            while (!queue.isEmpty() && queue.peek() <= first) {
                queue.poll();
                count++;
            }
            
            result.add(count);
        }
        
        // 리스트를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
