import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] adjList;
    static int[] rumor;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 0) break;
                adjList[i].add(number);
            }
        }

        rumor = new int[n+1];
        Arrays.fill(rumor, -1);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(st.nextToken());
            rumor[number] = 0;
            q.offer(new int[]{number, 0});
        }

        solve();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(rumor[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void solve() {
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int time = current[1];

            for (int nextNode : adjList[node]) {
                if (rumor[nextNode] == -1) {
                    int count = 0;
                    for (int nextNextNode : adjList[nextNode]) {
                        if (rumor[nextNextNode] != -1 && rumor[nextNextNode] <= time) {
                            count++;
                        }
                    }

                    int nextNodeSize = adjList[nextNode].size();
                    int half = nextNodeSize / 2;
                    if (nextNodeSize % 2 == 1) half += 1;

                    if (count >= half) {
                        rumor[nextNode] = time + 1;
                        q.offer(new int[]{nextNode, time + 1});
                    }
                }
            }
        }
    }
}