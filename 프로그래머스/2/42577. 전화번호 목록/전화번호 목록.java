import java.util.*;
class Solution {
    public boolean solution(String[] pb) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<pb.length-1; i++){
            map.put(pb[i], i);
        }
        
        for(int i=0; i<pb.length; i++){
            for(int j=0; j<pb[i].length(); j++){
                if(map.containsKey(pb[i].substring(0,j))) return false;
            }
        }
        return true;
    }
}