import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] up, down;
    static int N, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken()); // 길이
        H = Integer.parseInt(st.nextToken()); // 높이

        up = new int[N / 2]; // 밑에서부터 위로 자라는 애들
        down = new int[N / 2]; // 위에서부터 밑으로 자라는 애들

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                up[i / 2] = num;
            } else {
                down[i / 2] = num;
            }
        }

        Arrays.sort(up);
        Arrays.sort(down);

        int minObs = Integer.MAX_VALUE;
        int minCount = 0;

        for (int i = 1; i <= H; i++) {
            int upHit = countHit(up, i);
            int downHit = countHit(down, H - i + 1);
            int totalHits = upHit + downHit;
            
            if (totalHits < minObs) {
                minObs = totalHits;
                minCount = 1;
            } else if (totalHits == minObs) {
                minCount++;
            }
        }

        sb.append(minObs).append(" ").append(minCount);
        System.out.println(sb);
    }

    // 높이에서 부딪히는 장애물 수 게산
    static int countHit(int[] arr, int height) {
        int start = 0; // unchecked
        int end = arr.length - 1; // checked
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < height) {
                start = mid; // 기준보다 작으면 오른쪽 범위 탐색
            } else {
                end = mid; // 기준보다 크거나 같으면 왼쪽 범위 탐색
            }
        }
        if (arr[start] >= height) { // 모두 다
            return arr.length - start; // start부터 끝까지가 height보다 큰 장애물
        } else if (arr[end] >= height) {
            return arr.length - end; // end부터 끝까지가 height보다 큰 장애물
        } else {
            return 0; // height보다 큰 장애물 X
        }
    }
}