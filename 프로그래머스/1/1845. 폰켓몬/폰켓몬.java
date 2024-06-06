import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int numsSize = nums.length ;
        Set<Integer> s = new HashSet<Integer>();
        for(int i=0; i< numsSize; i++){
            s.add(nums[i]);
        }
        int answer = Math.min(numsSize / 2, s.size());
        return answer;
    }
}