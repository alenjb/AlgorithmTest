import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 핵심: 두 숫자를 이어붙인 문자열을 비교해 정렬
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // 예외 처리: 가장 큰 수가 0이면 전체가 0
        if (nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String num : nums) sb.append(num);

        return sb.toString();
    }
}
