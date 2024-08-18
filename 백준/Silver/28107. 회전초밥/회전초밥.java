import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 손님 수와 초밥 수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손님 수
        int M = Integer.parseInt(st.nextToken()); // 초밥 수

        // 손님별 먹은 초밥 수 배열 초기화
        int[] eat = new int[N + 1];
        // 초밥 리스트 배열 초기화
        LinkedList<Integer>[] sushi = new LinkedList[200_001];
        for (int i = 1; i <= 200_000; i++) {
            sushi[i] = new LinkedList<>();
        }

        // 손님들의 선호 리스트 채우기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int dishes = Integer.parseInt(st.nextToken());
            for (int j = 0; j < dishes; j++) {
                int now = Integer.parseInt(st.nextToken());
                sushi[now].add(i);
            }
        }

        // 요리사가 초밥을 만드는 과정
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int now = Integer.parseInt(st.nextToken()); // 요리사가 현재 만든 초밥
            if (sushi[now].size() > 0) { // 초밥을 먹을 사람이 있으면
                int eatPerson = sushi[now].remove(0);
                eat[eatPerson]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(eat[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}