import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> small = new PriorityQueue<Integer>();
        PriorityQueue<Integer> big = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for(String s : operations){
            int l = s.length();
            if(s.charAt(0) == 'I'){
                int num = Integer.parseInt(s.substring(2, s.length()));
                big.add(num);
                small.add(num);
            }else {                
                if (s.equals("D 1")) { //최대 삭제
                    Integer del = big.poll();
                    small.remove(del);
                }else if (s.equals("D -1")) { //최소 삭제
                    Integer del = small.poll();
                    big.remove(del);
                }
            }
        }
        if(small.isEmpty() && big.isEmpty()) return new int []{0,0};
        int[] answer = new int []{big.poll(), small.poll()};
        return answer;
    }
}