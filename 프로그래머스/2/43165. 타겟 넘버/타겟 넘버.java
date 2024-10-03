import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static int end = 0;
    static String [] s = {"-", "+"};
    public int solution(int[] numbers, int target) {
        end = numbers.length;
        perm("", 0);
        int answer = 0;
        StringTokenizer st;
    
        System.out.println(list.size());

        for(int i=0; i<list.size(); i++){
            int idx = 0;
            int tmp = 0;
            String ss = list.get(i);            
            for(int k=0; k<ss.length(); k++){
                char ns = ss.charAt(k);
                if(ns == '+'){
                    tmp += numbers[idx++];
                }else if(ns == '-'){
                    tmp -= numbers[idx++];
                }
            }
            
            if(tmp == target) answer++;
        }
        return answer;
    }
    
    static void perm(String now, int depth){
        if(depth == end){
            list.add(now); return;
        }else{
            for(int i=0; i<2; i++){
                perm(now+s[i], depth+1);
            }
        }
    }
}