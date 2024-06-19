import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> h = new HashMap<>();
        for (String name : participant) {
            if (h.get(name) != null) {
                h.put(name, h.get(name) + 1);
            } else {
                h.put(name, 1);
            }
        }
        for (String name1 : completion) {
            h.put(name1, h.get(name1) - 1);
        }
        for(String n : h.keySet()){
            if (h.get(n) == 1) answer = n;
        }
        return answer;
    }
}