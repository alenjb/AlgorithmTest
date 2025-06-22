import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        // 앞자리 체크
        PriorityQueue<String> pq = new PriorityQueue<>(
            new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String r1 = s1 + s2;
                String r2 = s2 + s1;
                return r2.compareTo(r1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int n : numbers){
            sb.append(n);
            pq.add(sb.toString());
            sb.setLength(0);
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        String answer = sb.toString();
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}