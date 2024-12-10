import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int[] answer = new int [2];

        String prev ="";
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(set.contains(word) || (!prev.equals("") && prev.charAt(prev.length()-1) != word.charAt(0))){
                answer =  new int[]{(i % n +1), (i / n + 1)};
                break;
            }else {
                set.add(word);
                prev = word;
            }
        }

        return answer;
    }
}