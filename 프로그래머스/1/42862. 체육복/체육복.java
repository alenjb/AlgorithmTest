import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // reserve에서 lost랑 겹치는거 제거
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> realLost = new ArrayList<>(); //진짜 잃어버린 애들
        for(int num : lost) realLost.add(num);

        List<Integer> avail = new ArrayList<>(); //진짜 빌려줄 수 있는 애들
        for(int num : reserve){
            if(!realLost.contains(num)) avail.add(num);
            else realLost.remove(Integer.valueOf(num));
        }
        
        int answer = n - realLost.size();
        for(int i=0; i<realLost.size(); i++){
            int prev = realLost.get(i) - 1;
            int next = realLost.get(i)+ 1;
            if(avail.contains(prev)) {
                answer++;
                avail.remove(Integer.valueOf(prev));
            }else if(avail.contains(next)){
                answer++;
                avail.remove(Integer.valueOf(next));
            }
        }
        return answer;
    }
}