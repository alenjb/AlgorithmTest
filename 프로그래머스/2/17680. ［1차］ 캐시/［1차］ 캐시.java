import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        List<String> cache = new LinkedList<>();
        int time = 0;

        for (String city : cities) {
            String now = city.toUpperCase();

            if (cache.contains(now)) { // 캐싱됨
                cache.remove(now);
                cache.add(now);
                time += 1;
            } else { // 캐싱 안됨
                if (cache.size() == cacheSize) {
                    cache.remove(0); // 가장 오래된 것 제거
                }
                cache.add(now);
                time += 5;
            }
        }

        return time;
    }
}