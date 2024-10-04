import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = bs(0, citations.length+1, citations);
        return answer;
    }
    // start check end uncehcked 0, citations.length+1
    static int bs(int start, int end, int[] citations){
        while(start +1 < end){
            int mid = (start + end) /2;
            if(check(mid, citations)) start = mid;
            else end = mid;
        }
        return start;
    }
    static boolean check(int num, int[] citations){
        int cnt = 0;
        for(int i=0; i<citations.length; i++){
            if(citations[i] >= num) cnt++;
            if(cnt >= num) return true;
        }
        return false;
    }
}