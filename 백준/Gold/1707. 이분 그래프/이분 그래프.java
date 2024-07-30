import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int v, e;
    static int[] color; // 0: 방문 안함, 1, -1
    static List<Integer>[] arr;
    static boolean isnot = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            color = new int[v + 1];
            arr = new ArrayList[v + 1];
            for (int j = 0; j < v + 1; j++) {
                arr[j] = new ArrayList<>();
            }
            // 인접 리스트 배열에 저장
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                arr[start].add(end);
                arr[end].add(start); // 무방향 그래프이므로 양쪽에 추가
            }

            isnot = false; // 각 테스트 케이스마다 초기화
            for (int j = 1; j < v + 1; j++) {
                if (color[j] == 0) { // 방문하지 않은 정점에 대해 DFS 수행
                    DFS(j, 1);
                    if (isnot) break;
                }
            }

            if (isnot) bw.write("NO\n");
            else bw.write("YES\n");
        }
        bw.flush();
    }

    public static void DFS(int num, int prevNum) {
        if (color[num] == 0) { // 방문을 안했으면
            color[num] = prevNum;
            for (int i = 0; i < arr[num].size(); i++) {
                int now = arr[num].get(i);
                if (color[now] == 0) {
                    DFS(now, -prevNum);
                    if (isnot) return; // 재귀 호출 중 이분 그래프 아님이 판별되면 종료
                } else if (color[now] == prevNum) { // 이분이 아니면
                    isnot = true;
                    return;
                }
            }
        }
    }
}
