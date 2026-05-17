import java.util.*;
class Solution {
    public int[] solution(int[] seq, int k) {
        int left = 0;
        int right = 0;
        int sum = seq[left];
        int[] answer = new int []{0, seq.length};


        while(left <=right && right <seq.length){
            if(sum > k){
                sum-=seq[left++];
            }else if(sum < k){
                if(right+1 == seq.length) return answer;
                sum+=seq[++right];                    
            }else{
                // 짧은가?
                if((answer[1] - answer[0]) > right - left){
                answer[0] = left;
                answer[1] = right;             
                }
                sum-=seq[left++];
            }
        }
        return answer;
    }
}