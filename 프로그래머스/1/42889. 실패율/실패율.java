import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failStage = new int[N + 1];
        int[] passStage = new int[N + 1];

        // 실패/통과 계산
        for (int i = 0; i < stages.length; i++) {
            int now = stages[i];
            for (int j = 1; j < now; j++) { // 통과한 스테이지
                passStage[j]++;
            }
            if (now <= N) { // 현재 스테이지가 N 이하일 때 실패한 사람 수 기록
                failStage[now]++;
            }
        }

        // 우선순위 큐 생성 (Comparator 사용)
        PriorityQueue<Result> pq = new PriorityQueue<>(new Comparator<Result>() {
            public int compare(Result s1, Result s2) {
                double first = (s1.pass == 0) ? 0 : (double) s1.fail / s1.pass; // 실패율 계산
                double second = (s2.pass == 0) ? 0 : (double) s2.fail / s2.pass;
                if (first == second) { // 실패율이 같다면 번호 순으로 정렬
                    return s1.num - s2.num;
                }
                return Double.compare(second, first); // 실패율 내림차순
            }
        });

        // 결과 큐에 추가
        for (int i = 1; i <= N; i++) {
            pq.add(new Result(i, failStage[i], passStage[i] + failStage[i]));
        }

        // 정답 배열 생성
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = pq.poll().num;
        }
        return answer;
    }

    // Result 클래스 정의
    static class Result {
        int num; // 스테이지 번호
        int fail; // 실패한 사람 수
        int pass; // 도달한 사람 수

        public Result(int n, int f, int p) {
            this.num = n;
            this.fail = f;
            this.pass = p;
        }
    }
}
