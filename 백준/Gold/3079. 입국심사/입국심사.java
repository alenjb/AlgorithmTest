import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] times;
    static int N, M;
    static long minTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 심사대 수
        M = Integer.parseInt(st.nextToken()); // 사람 수

        times = new int[N];
        minTime = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            times[i] = now;
            minTime = Math.min(minTime, now);
        }

        long result = bs(0, minTime * M);
        System.out.println(result);
    }

    static long bs(long start, long end) {
        while (start + 1 < end) {
            long mid = (start + end) / 2;
            if(check(mid)) end = mid;
            else start = mid;
        }
        return end;
    }

    static boolean check(long num) {
        long cnt = 0;
        for(int time : times) {
            cnt += num / time;
        }
        return cnt >= M;
    }
}