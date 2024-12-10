import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken()); // 오븐의 깊이
        int N = Integer.parseInt(st.nextToken()); // 반죽의 개수

        int[] oven = new int[D]; // 오븐
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) oven[i] = Integer.parseInt(st.nextToken());

        int[] baking = new int[N]; // 반죽
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) baking[i] = Integer.parseInt(st.nextToken());

        // 오븐 크기 최소에 맞게
        for (int i = 1; i < D; i++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        int last = D - 1; // 오븐의 가장 아래부터 시작(인덱스로)
        for (int i = 0; i < N; i++) { // 각 반죽에 대해
            while (last >= 0 && baking[i] > oven[last]) { // 반죽이 들어갈 수 없는 위치를 건너뛰기
                last--;
            }

            if (last < 0) { // 반죽을 넣을 공간이 없는 경우
                System.out.println(0);
                return;
            }

            // 반죽을 현재 위치에 넣고 다음 반죽으로 이동
            last--;
        }

        System.out.println(last + 2); // -가 추가로 되었고 인덱스가 아닌 실제 위치로 해야하므로 +2
    }
}