import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(enroll[i], i);
        }

        int[] money = new int[n];
        
        for (int i = 0; i < seller.length; i++) {
            String cur = seller[i];
            int profit = amount[i] * 100;

            while (!cur.equals("-")) {
                int idx = map.get(cur);
                int toParent = profit / 10;
                money[idx] += profit - toParent;

                if (toParent < 1) break; // 1원 미만은 전달 안 함
                cur = referral[idx];     // 상위로 이동
                profit = toParent;
            }
        }

        return money;
    }
}
