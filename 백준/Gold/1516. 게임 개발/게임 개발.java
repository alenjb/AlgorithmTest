import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] in = new int[N]; // 진입 차수
        int[] times = new int[N]; // 기본 건설 시간
        int[] answers = new int[N]; // 누적 건설 시간

        List<Integer>[] arr = new ArrayList[N]; // 후속 건물 리스트
        for (int i = 0; i < N; i++) arr[i] = new ArrayList<>();

        for (int tc = 0; tc < N; tc++) {
            int time = sc.nextInt();
            times[tc] = time;

            while (true) {
                int num = sc.nextInt();
                if (num == -1) break;

                in[tc]++;
                arr[num - 1].add(tc);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (in[i] == 0) {
                pq.add(i);
                answers[i] = times[i]; // 초기값 설정
            }
        }

        while (!pq.isEmpty()) {
            int now = pq.poll();

            for (int next : arr[now]) {
                in[next]--;
                answers[next] = Math.max(answers[next], answers[now] + times[next]);
                if (in[next] == 0) {
                    pq.add(next);
                }
            }
        }

        for (int ans : answers) System.out.println(ans);
    }
}
