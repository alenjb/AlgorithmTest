import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int total = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        
        map.put(gems[0], 1);
        
        while (right < gems.length) {
            if (map.size() == total) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                String gem = gems[left];
                map.put(gem, map.get(gem) - 1);
                if (map.get(gem) == 0) map.remove(gem);
                left++;
            } else {
                right++;
                if (right == gems.length) break;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            }
        }

        return new int[]{start + 1, start + minLen + 1};
    }
}
