class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int currentPos = 1; // 현재 커버 중인 위치

        for (int station : stations) {
            int start = station - w;
            int end = station + w;

            // 현재 커버 범위(currentPos)와 다음 기지국의 시작 위치(start) 사이의 비어 있는 영역 계산
            if (start > currentPos) {
                int gap = start - currentPos; // 커버되지 않은 영역 크기
                answer += (gap + (2 * w)) / (2 * w + 1); // 필요한 기지국 개수
            }

            // 현재 위치를 이번 기지국의 커버 범위 이후로 이동
            currentPos = end + 1;
        }

        // 마지막 기지국 이후에 남아 있는 영역 처리
        if (currentPos <= n) {
            int gap = n - currentPos + 1; // 커버되지 않은 영역 크기
            answer += (gap + (2 * w)) / (2 * w + 1); // 필요한 기지국 개수
        }

        return answer;
    }
}
