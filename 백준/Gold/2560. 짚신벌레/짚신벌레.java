import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a, b, d, N;
    static long [] total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken()); // 번식 시작 일자
        b = Integer.parseInt(st.nextToken()); // 번식 종료 일자
        d = Integer.parseInt(st.nextToken()); // 사망 일자
        N = Integer.parseInt(st.nextToken()); // 구하는 날
        total = new long[N+1];

        total[0] = 1;

        // 1 ~ b
        for(int time=1; time<=b; time++){
            if(time <a) total[time] = total[time-1];
            else {
                total[time] = total[time-1] % 1000 + total[time - a] % 1000;
            }
        }

        for(int time = b; time<=N; time++){
            total[time] = ((total[time-1] - total[time - b] +1000) % 1000)  + total[time - a] % 1000;
        }

        long result = -2;
        if(N >= d) result = (total[N] - total[N-d] + 1000) % 1000;
        else result = (total[N]) % 1000;
        System.out.println(result);

    }

}