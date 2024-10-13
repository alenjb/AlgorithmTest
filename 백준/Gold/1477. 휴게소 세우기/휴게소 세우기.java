import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, L;
    static int [] arr; //휴게소 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 기존 휴게소 개수
        M = Integer.parseInt(st.nextToken());  // 새로 지을 휴게소 개수
        L = Integer.parseInt(st.nextToken());  // 고속도로 길이
        arr = new int[N+2]; 
        
        arr[0] = 0;  // 시작점
        arr[N+1] = L;  // 끝점

        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i+1] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
        int result = bs(N, M, L);
        
        System.out.println(result);
    }

    private static int bs(int N, int M, int L) {
        int left = 1;  // 최소 간격
        int right = L - 1;  // 최대 간격
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;  // 휴게소 사이의 중간 거리
            int need = 0;

            // 설치 가능한 휴게소
            for (int i = 1; i < N + 2; i++) {
                int canPlus = arr[i] - arr[i-1];
                need += (canPlus - 1) / mid;
            }

            if (need > M) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}