import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(map.get(clothes[i][1]) == null) map.put(clothes[i][1], 1);
            else {
                int num = map.get(clothes[i][1]);
                map.put(clothes[i][1], num + 1);
                }
            }
                    
        
        int answer = 1;
        for(String key : map.keySet()){
            answer *= (map.get(key)+1);
        }
        answer--;
        return answer;
    }
}