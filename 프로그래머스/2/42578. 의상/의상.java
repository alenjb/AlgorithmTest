import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int n = clothes.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n ;i++){
            String s =  clothes[i][0];
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0)+1);
        }
        int sum = 1;
        for(int num : map.values()){
            sum = sum * (num +1);
        }
        sum--;
        return sum;
    }
}