import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static String [] poss = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        perm("", 0);
        int result = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)) {
                result =  i;
                break;
            }
        }
        return result;
        
    }
    
    void perm(String nowWord, int depth){
        list.add(nowWord);
 
        if(depth ==5){
            return;
        }
        for(int i=0; i<5; i++){
            perm(nowWord+ poss[i], depth+1);
        }
    }
    
}