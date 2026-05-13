class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int y = 1; y <= total; y++) {
            if (total % y == 0) {
                int x = total / y;

                // x >= y 조건 (가로가 더 길게)
                if (x >= y) {
                    if ((x - 2) * (y - 2) == yellow) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return new int[]{};
    }
}