import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static long [][] dist;
    static int [] cuttingPoint, cuttingNumber;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        cuttingPoint = new int[M]; // 자르는 위치
        cuttingNumber = new int[N]; // 자르는 횟수

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            cuttingPoint[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cuttingNumber[i] = Integer.parseInt(st.nextToken());
        }


        for(int t=0; t< N; t++){
            // 최대값을 정하기 = k
            int K = L / cuttingNumber[t];

            // 0과 k를 이분탐색 ->
            int result = bs(0 , K, cuttingNumber[t]+1);
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    // s는 범위 밖, e는 범위 안
    private static int bs(int s, int e, int max) {
        int mid = -1;
        while (s <= e){
            mid = (s + e) / 2;
            if(check(mid, max)){
                s = mid+1;
            }else e = mid -1;
        }
        return e;
    }
    static boolean check(int num, int max){
        int cnt = 0;  // 자른 횟수
        int lastCut = 0; // 마지막으로 자른 위치

        for (int i = 0; i < M; i++) {
            if (cuttingPoint[i] - lastCut >= num) {
                cnt++;
                lastCut = cuttingPoint[i];
            }
        }

        // 마지막으로 남은 부분
        if (L - lastCut >= num) {
            cnt++;
        }

        return cnt >= max;
    }

}