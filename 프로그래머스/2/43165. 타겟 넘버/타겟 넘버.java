import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        plus(0, numbers, target, 0);
        minus(0, numbers, target, 0);
        return answer;
    }
    public static void plus(int now, int []nums, int target, int idx){
        now += nums[idx++];
        if(idx == nums.length) {
            if(now == target) answer++;
            return;
        }
        plus(now, nums, target, idx);
        minus(now, nums, target, idx);
    }
    public static void minus(int now, int []nums, int target, int idx){
        now -= nums[idx++];
        if(idx == nums.length) {
            if(now == target) answer++;
            return;
        }
        plus(now, nums, target, idx);
        minus(now, nums, target, idx);
    }
}