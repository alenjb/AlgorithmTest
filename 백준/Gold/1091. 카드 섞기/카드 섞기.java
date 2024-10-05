import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N; // 카드 수
    static int P[]; // 각 카드가 최종적으로 있어야 하는 플레이어
    static int S[]; // 섞는 방법을 저장하는 배열
    static int current[]; // 현재 카드가 어떤 플레이어에게 있는지 저장하는 배열
    static int tmp[]; // 섞는 중간에 사용되는 임시 배열
    static boolean finalCards[][] = new boolean[3][48]; // 각 플레이어가 최종적으로 가져야 할 카드 정보를 저장하는 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 카드 수 입력받기
        current = new int[N];
        tmp = new int[N];
        P = new int[N];
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        // 각 플레이어가 최종적으로 가져야 할 카드 정보를 true 설정
        for (int i = 0; i < N; i++) {
            finalCards[P[i]][i] = true;
            current[i] = i; // 초기 상태에서 카드는 각 인덱스와 동일한 번호의 플레이어에게 있음
        }

        int answer = -1;

        Set<String> seen = new HashSet<>();

        for (int cnt = 0; cnt <= 120121; cnt++) {

            // 현재 상태가 모든 카드가 올바른 플레이어에게 있는지 확인
            boolean isCorrect = true;
            for (int i = 0; i < N; i++) {
                if (!finalCards[i % 3][current[i]]) {
                    isCorrect = false;
                    break;
                }
            }

            // 모든 카드가 올바르게 배치된 경우
            if (isCorrect) {
                answer = cnt;
                break;
            }

            // 현재 상태를 문자열로 변환해 Set에 저장
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(current[i]).append(",");
            }

            String currentState = sb.toString();

            if (seen.contains(currentState)) { // 같은 상태 존재
                answer = -1;
                break;
            }

            seen.add(currentState);

            // 카드를 S 배열에 따라 섞기
            for (int i = 0; i < N; i++) {
                tmp[S[i]] = current[i];
            }
            for (int i = 0; i < N; i++) {
                current[i] = tmp[i];
            }
        }

        System.out.println(answer);
    }
}