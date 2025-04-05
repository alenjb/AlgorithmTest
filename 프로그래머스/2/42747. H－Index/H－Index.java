import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int left = 0;
        int right = citations.length;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isValid(mid, citations)) {
                answer = mid;     // 조건 만족: 더 큰 h 가능성 확인
                left = mid + 1;
            } else {
                right = mid - 1;  // 조건 불만족: h를 줄여야 함
            }
        }

        return answer;
    }

    private boolean isValid(int h, int[] citations) {
        int count = 0;
        for (int c : citations) {
            if (c >= h) count++;
        }
        return count >= h;
    }
}
