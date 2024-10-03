import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(op.equals("I")) {
                list.add(num);
                Collections.sort(list);
            }
            else if(op.equals("D")){
                if(num == -1 && list.size()>0){
                    list.remove(0);
                }else if(list.size()>0){
                    list.remove(list.size()-1);
                }
            }
        }
        int max = 0;
        int min = 0;
        if(list.size()>0){
            if(list.size()>=2){
                max = list.get(list.size()-1);
                min = list.get(0);
            }else{
                int tmp = list.get(0);
                max = tmp;
                min = tmp;
            }
        }
        int[] answer = {max, min};
        return answer;
    }
}