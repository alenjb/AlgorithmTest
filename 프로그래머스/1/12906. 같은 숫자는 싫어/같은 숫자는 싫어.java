import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i< arr.length; i++){
            if(i!= arr.length-1 && arr[i] == arr[i+1]) continue;
            int a = arr[i];
            l.add(a);
        }
        int size = l.size();
        int[] answer = new int [size];
        for(int i=0; i<l.size(); i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}