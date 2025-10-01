import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> ss = new ArrayList<>();
        for(int n : numbers) ss.add(n + "");
        Collections.sort(ss, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        System.out.print(ss.size());
        StringBuilder sb = new StringBuilder();
        for(String sss : ss) sb.append(sss);
        String result = sb.toString();
        if(result.charAt(0) == '0') return "0";
        return sb.toString();
    }
}