import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        int l = numbers.length;
        StringBuilder sb = new StringBuilder();
        String [] numbs = new String[l];
        
        for(int i=0; i<l; i++) numbs[i] = numbers[i] + "";
        Arrays.sort(numbs, new Comparator<String>(){
            public int compare(String s1, String s2) {
                // 앞에 붙였을 때 큰 쪽이 먼저 오게 정렬
                String order1 = s1 + s2;
                String order2 = s2 + s1;
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });
        
        if(numbs[0].equals("0")) return "0";
        
        for(String s : numbs) sb.append(s);
        return sb.toString();
    }
}