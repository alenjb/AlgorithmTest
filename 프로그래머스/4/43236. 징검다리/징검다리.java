import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        int left = 0;              // 항상 가능
        int right = distance + 1;  // 항상 불가능 (sentinel)

        while (left + 1 < right) {
            int mid = (left + right) / 2; // 최소거리 후보
            if (check(distance, rocks, n, mid)) {
                left = mid;   // 가능 → 더 크게 (가능한 쪽으로 당김)
            } else {
                right = mid;  // 불가능 → 줄이기 (불가능한 쪽으로 당김)
            }
        }
        // left는 "가능한 값들 중 최댓값"에 수렴
        return left;
    }

    static boolean check(int distance, int[] rocks, int n, int num) {
        int removed = 0;
        int prev = 0;

        for (int rock : rocks) {
            if (rock - prev < num) { // 최소거리 미달 → 제거
                removed++;
            } else {
                prev = rock;
            }
        }
        if (distance - prev < num) removed++; // 마지막 구간

        return removed <= n;
    }
}
