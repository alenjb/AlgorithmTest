import java.util.*;
class Solution {
    public boolean solution(String[] pb) {
        int n = pb.length;
        Arrays.sort(pb);
        for(int i=0; i<n-1; i++){
            if(pb[i+1].startsWith(pb[i])) return false;
        }
        return true;
    }
}