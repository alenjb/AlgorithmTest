import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<Integer>[] next;
    static int[] inDegree;
    static int v;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            // 입력받기
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken()); // 정점의 개수
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수

            next = new ArrayList[v + 1];
            inDegree = new int[v + 1];
            for (int i = 0; i <= v; i++) {
                next[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < e; i++) {
                int from = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                next[from].add(end);
                inDegree[end]++;
            }

            topSort();
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void topSort() {
        Queue<Integer> q = new ArrayDeque<>();
        
        // 진입 차수가 0인 노드를 큐에 삽입
        for (int i = 1; i <= v; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");
            
            for (int num : next[now]) {
                inDegree[num]--;
                
                // 진입 차수가 0이 되면 큐에 삽입
                if (inDegree[num] == 0) {
                    q.add(num);
                }
            }
        }
        sb.append("\n");
    }
}