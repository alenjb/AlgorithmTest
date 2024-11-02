import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int count = 0;
    static int min = Integer.MAX_VALUE;
    static int[] time = new int [100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        if (N >= K) {
            sb.append((N - K)).append("\n").append(1);
            System.out.println(sb);
            return;
        }

        q.offer(N);
        time[N] = 1;
        // BFS
        while (!q.isEmpty()) {
            int poll = q.poll();

            if (min < time[poll]) break;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = poll + 1;
                } else if (i == 1) {
                    next = poll - 1;
                } else {
                    next = poll * 2;
                }

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    min = time[poll];
                    count++;
                }

                if (time[next] == 0 || time[next] == time[poll] + 1) {
                    q.add(next);
                    time[next] = time[poll] + 1;
                }
            }
        }
        sb.append(min).append("\n").append(count);
        System.out.println(sb);
    }
}