import java.util.*;

class Solution {
    static int cnt = 1000000;
    static List<Integer>[] arr;

    public int solution(int n, int[][] wires) {
        arr = new ArrayList[n + 1]; // 제네릭 배열 생성
        // 초기화 수정: `arr[i] = new ArrayList<>();`는 1부터 n까지 초기화 필요
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 그래프 연결
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }

        // 간선 하나씩 끊어가며 확인
        for (int i = 0; i < wires.length; i++) {
            int count = 0;
            int a = wires[i][0];
            int b = wires[i][1];

            // 간선 제거
            arr[a].remove(Integer.valueOf(b));
            arr[b].remove(Integer.valueOf(a));

            // BFS 수행
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            q.add(1);
            while (!q.isEmpty()) {
                int poll = q.poll();
                if (visited[poll]) continue; // 방문 여부 확인
                visited[poll] = true;
                count++;
                for (int num : arr[poll]) {
                    if (!visited[num]) q.add(num);
                }
            }

            // 최소 차이 갱신
            cnt = Math.min(cnt, Math.abs(count - (n - count)));

            // 간선 복원
            arr[a].add(b);
            arr[b].add(a);
        }
        return cnt;
    }
}
