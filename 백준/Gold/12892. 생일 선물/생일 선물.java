import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, D;
    static Node[] nodes;
    static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 친구 수
        D = Integer.parseInt(st.nextToken()); // 최소 가격 차

        nodes = new Node[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(P, V);
        }

        Arrays.sort(nodes);

        int left = 0;
        long tmp = 0;

        for (int right = 0; right<N; right++) {
            tmp += nodes[right].value;

            // 가격 차이가 D 이상일 때까지 left 이동
            while (nodes[right].price - nodes[left].price >= D) {
                tmp -= nodes[left].value;
                left++;
            }
            result = Math.max(result, tmp);
        }

        System.out.println(result);
    }

    static class Node implements Comparable<Node> {
        long price;
        int value;

        public Node(long price, int value) {
            this.price = price;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.price, o.price);
        }
    }
}