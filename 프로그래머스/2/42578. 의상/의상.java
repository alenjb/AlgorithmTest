import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1];
            if(map.get(type) != null){
                int now = map.get(type);
                map.put(type, now+1);
            }else map.put(type, 1);
        }
        int answer = 1;
        for(int num : map.values()){
            answer *= (num+1);
        }
        return answer-1;
    }
}