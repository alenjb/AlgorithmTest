import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] sensor;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 센서 개수
        K = Integer.parseInt(br.readLine()); // 집중국 개수

        sensor = new int[N]; // 센서
        dist = new int[N-1]; // 센서 사이의 거리

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) sensor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sensor);

        // 사이 거리 구하기
        for (int i=0; i<N-1; i++) dist[i] = sensor[i+1] - sensor[i];

        // 거리 오름차순 정렬
        Arrays.sort(dist);

        int result = 0;

        // 가장 큰 K개 사이 거리 빼고 더하기
        for (int i = 0; i < N-K; i++) result += dist[i];

        System.out.println(result);
    }
}