import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static PriorityQueue<Node8> dist;
    static double E;
    static int[] parent;
    static int[] xs, ys;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            parent = new int[N + 1];
            xs = new int[N + 1];
            ys = new int[N + 1];
            dist = new PriorityQueue<>();

            for (int i = 1; i <= N; i++) parent[i] = i;

            // 노드 위치 저장
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                xs[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                ys[i] = Integer.parseInt(st.nextToken());
            }

            // 가중치 입력
            st = new StringTokenizer(br.readLine());
            E = Double.parseDouble(st.nextToken());

            // 거리 계산
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    int x1 = xs[i];
                    int y1 = ys[i];
                    int x2 = xs[j];
                    int y2 = ys[j];
                    double w = (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) * E;
                    dist.add(new Node8(i, j, w));
                }
            }

            int cnt = 0;
            double result = 0;
            while (cnt < N - 1) {
                Node8 poll = dist.poll();
                int start = poll.s;
                int end = poll.e;

                int rootS = find(start);
                int rootE = find(end);

                if (rootS != rootE) {
                    union(start, end);
                    result += poll.w;
                    cnt++;
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");
        }

        System.out.print(sb);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }

    static int find(int num) {
        if (num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}

class Node8 implements Comparable<Node8> {
    int s, e;
    double w;

    public Node8(int s, int e, double w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node8 o) {
        return Double.compare(this.w, o.w);
    }
}