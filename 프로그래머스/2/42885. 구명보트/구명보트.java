import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int answer = 0;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 가벼운 사람과 무거운 사람을 함께 태움
                i++;
            }
            // 무거운 사람은 무조건 보냄
            j--;
            answer++;
        }

        return answer;
    }
}
