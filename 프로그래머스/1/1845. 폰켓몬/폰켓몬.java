import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int numsSize = nums.length ;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i< numsSize; i++){
            set.add(nums[i]);
        }
        int answer = Math.min(numsSize / 2, set.size());
        return answer;
    }
}