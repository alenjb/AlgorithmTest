import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> comp = new HashMap<>(); // 완주한 사람
        
        for(String s : completion) {
            if(comp.containsKey(s)) comp.put(s, comp.get(s) + 1);
            else comp.put(s, 1);
        } 
        
        for(String p : participant){
            if(!comp.containsKey(p)) return p;
            else{
                int num = comp.get(p);
                if(num <=0) return p;
                comp.put(p, num - 1);   
            }
        }
        return null;
    }
}