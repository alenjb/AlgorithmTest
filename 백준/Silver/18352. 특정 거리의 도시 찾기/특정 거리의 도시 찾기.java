import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();
        
        // 배열 저장
        List<Integer>[] arr = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[x] = 0;
        q.add(x);

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : arr[current]) {
                if (distance[next] == -1) { // not visited
                    distance[next] = distance[current] + 1;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            bw.write("-1\n");
        } else {
            Collections.sort(result);
            for (int city : result) {
                bw.write(city + "\n");
            }
        }
        bw.flush();
    }
}
