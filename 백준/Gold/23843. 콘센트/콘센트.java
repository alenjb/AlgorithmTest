import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int [] times;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전자기기 수
        M = Integer.parseInt(st.nextToken()); // 콘센트 수
        times = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) times[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(times);

        int start = 0;
        int end = (int) (N * Math.pow(2, 15));
        while (start + 1 < end){
            int mid = (start + end) / 2;
            if(check(mid)) end = mid;
            else start = mid;
        }

        System.out.println(end);
    }

    static boolean check(int num){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<M; i++) pq.add(0); // 처음에는 모든 큐가 0이니까

        for(int i=N-1; i>=0; i--){
            int now = times[i];
            int poll = pq.poll();
            if(poll + now > num) return false;
            pq.add(now + poll);
        }
        return true;
    }
}