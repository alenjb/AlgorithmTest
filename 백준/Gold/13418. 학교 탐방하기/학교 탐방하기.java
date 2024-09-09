import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static Queue<Node> asc = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
    private static Queue<Node> desc = new PriorityQueue<>((v1, v2) -> v2.weight - v1.weight);
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 건물
        M = Integer.parseInt(st.nextToken()); // 도로]

        parents = new int[N + 1];

        // 내리막길 가중치는 1, 오르막길 가중치는 K^2
        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            asc.add(new Node(v1, v2, weight));
            desc.add(new Node(v1, v2, weight));
        }

        Arrays.fill(parents, -1);
        int edgeCount = 0;
        int maxCost = 0;
        while ((edgeCount <= N) && !asc.isEmpty()) {
            Node node = asc.poll();
            if (union(node.v1, node.v2)) {
                edgeCount++;
                maxCost += node.weight;
            }
        }
        maxCost = (N - maxCost) * (N - maxCost); // 비용은 (오르막길 수^2)

        Arrays.fill(parents, -1);
        edgeCount = 0;
        int minCost = 0;
        while ((edgeCount < N) && !desc.isEmpty()) {
            Node node = desc.poll();
            if (union(node.v1, node.v2)) {
                edgeCount++;
                minCost += node.weight;
            }
        }
        minCost = (N - minCost) * (N - minCost);

        bw.write(maxCost - minCost + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 != num2) {
            parents[num2] = num1;
            return true;
        }
        return false;
    }

    private static int find(int num) {
        if (parents[num] < 0) return num;
        return parents[num] = find(parents[num]);
    }
    static class Node {
        int v1, v2, weight;

        public Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

}