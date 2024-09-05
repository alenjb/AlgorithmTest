import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s, t;
    static List<Integer>[] arr, rArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // Number of vertices
        m = Integer.parseInt(st.nextToken()); // Number of edges
        arr = new ArrayList[n + 1];
        rArr = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
            rArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            rArr[y].add(x);
        }
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        boolean[] fromS = new boolean[n + 1];
        fromS[t] = true;
        dfs(s, arr, fromS);

        boolean[] fromT = new boolean[n + 1];
        fromT[s] = true;
        dfs(t, arr, fromT);

        boolean[] toS = new boolean[n + 1];
        dfs(s, rArr, toS);

        boolean[] toT = new boolean[n + 1];
        dfs(t, rArr, toT);

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (fromS[i] && fromT[i] && toS[i] && toT[i])
                cnt++;
        }

        System.out.println(cnt - 2);
    } // main

    static void dfs(int now, List<Integer>[] adj, boolean[] visit) {
        if (visit[now]) return;
        visit[now] = true;
        for (int x : adj[now])
            dfs(x, adj, visit);
    }
}
