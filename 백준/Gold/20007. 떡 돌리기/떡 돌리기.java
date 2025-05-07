import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 집의 개수
        int M = sc.nextInt(); // 도로의 개수
        int X = sc.nextInt(); // 하루 최대갈 수 있는 거리
        int Y = sc.nextInt(); // 성현의 집

        List<Node>[] arr = new List[N];
        for(int i=0; i<N; i++) arr[i] = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            Node node = new Node(end, weight);
            arr[start].add(node);
            arr[end].add(new Node(start, weight)); // 양방향 도로
        }

        int [] dist = new int[N];
        for(int i=0; i<N; i++) dist[i] = Integer.MAX_VALUE;
        dist[Y] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(Y, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int end = poll.e;
            if (visited[end]) continue;
            visited[end] = true;

            for (Node nn : arr[end]) {
                int next = nn.e;
                int nextW = nn.w;
                if (!visited[next] && dist[end] + nextW < dist[next]) {
                    dist[next] = dist[end] + nextW;
                    pq.add(new Node(next, dist[next])); // 수정된 부분
                }
            }
        }

        // 이제 방문 가능한 거리들만 수집
        List<Integer> distances = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i == Y) continue;
            if (dist[i] * 2 <= X) { // 왕복 거리 기준
                distances.add(dist[i]);
            }
        }

        // 정렬 후 하루에 X 이내로 가능한 만큼 묶기
        Collections.sort(distances);
        int answer = 0;
        int i = 0;
        while (i < distances.size()) {
            int daily = 0;
            // 한 번에 최대한 많이 방문
            while (i < distances.size() && daily + distances.get(i) * 2 <= X) {
                daily += distances.get(i) * 2;
                i++;
            }
            answer++;
        }

        if (distances.size() != N - 1) System.out.println(-1);
        else System.out.println(answer);


    }
    public static class Node implements Comparable<Node>{
        int e;
        int w;

        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {
            return this.w - n.w;
        }
    }
}
