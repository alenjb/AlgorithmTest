import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        // 교집합 제거
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int l : lost) {
            boolean found = false;
            for (int i = 0; i < reserve.length; i++) {
                if (l == reserve[i]) {
                    reserve[i] = -1;
                    found = true;
                    break;
                }
            }
            if (!found) lostList.add(l);
        }
        for (int r : reserve) {
            if (r != -1) reserveList.add(r);
        }

        // 도난당한 학생 기준
        for (int i = 0; i < lostList.size(); i++) {
            int student = lostList.get(i);
            if (reserveList.contains(student - 1)) {
                reserveList.remove(Integer.valueOf(student - 1));
                lostList.set(i, -1); // 빌림 처리
            } else if (reserveList.contains(student + 1)) {
                reserveList.remove(Integer.valueOf(student + 1));
                lostList.set(i, -1); // 빌림 처리
            }
        }

        int unable = 0;
        for (int l : lostList) {
            if (l != -1) unable++;
        }
        return n - unable;
    }
}
