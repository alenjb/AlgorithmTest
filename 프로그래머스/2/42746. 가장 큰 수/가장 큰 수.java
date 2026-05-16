import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for(int num : numbers) list.add(num + "");
        Collections.sort(list, (a, b) -> (b+a).compareTo(a+b));
        String answer = "";
        if(list.get(0).equals("0")) return "0";
        for(String s : list) answer += s;
        return answer;
    }
}