import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception { // ✅ 수정: main()에 String[] args 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        arr = (List<Integer>[]) new ArrayList[n + 1]; // ✅ 수정: 제네릭 배열 생성 시 타입 캐스팅 추가
        visited = new boolean[n + 1];

        // ✅ 수정: 배열 초기화
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 정점 번호
            int b = Integer.parseInt(st.nextToken()); // 연결된 정점 번호
            arr[a].add(b);
            arr[b].add(a);
        }

        int count = 0;

        // DFS 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static void DFS(int num) {
        if (visited[num]) return;
        visited[num] = true;

        for (int next : arr[num]) {
            if (!visited[next]) DFS(next);
        }
    }
}
