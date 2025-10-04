import java.util.*;
class Solution {
    static List<String> cmdList = new ArrayList<>();
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int l = numbers.length;

        // + - 만들 수 있는 순열
        pri("", l);
        
        
        for(int i=0; i<cmdList.size(); i++){
            // 계산하기
            int sum = cal(numbers, cmdList.get(i));
            if(sum == target) answer++;            
        }
        return answer;
    }
    static int cal(int [] numbers, String cmds){
        int sum = cmds.charAt(0) == '-' ?  -numbers[0] : numbers[0];
        for(int i=1; i<numbers.length; i++){
            char c = cmds.charAt(i);
            if(c == '-') sum -= numbers[i];
            else sum += numbers[i];
        }
        return sum;    
    }
    
    static void pri(String cmds, int limit){
        if(cmds.length() == limit) {
            cmdList.add(cmds);
            return;
        }
        
        pri(cmds+"-", limit);
        pri(cmds+"+", limit);
    }
}