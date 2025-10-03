import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String c : completion) map.put(c, map.getOrDefault(c, 0) +1);
        
        for(String p : participant){
            int num = map.getOrDefault(p, 0);
            if(num == 0) return p;
            map.put(p, num-1);
        }
        
        return null;
    }
}