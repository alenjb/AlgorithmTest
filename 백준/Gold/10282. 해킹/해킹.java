import java.util.*;

public class Main {
    static int n, d, c;
    static List<Node>[] arr;
    static int [] dist;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt(); //테스트 개수
        for(int t=0; t<T; t++){
            n = sc.nextInt(); // 컴퓨터 개수
            d = sc.nextInt(); // 의존성 개수
            c = sc.nextInt(); // 해킹당한 번호

            dist = new int[n+1];
            visited = new boolean[n+1];
            arr = new List[n+1];

            for(int i=1; i<=n; i++) arr[i] = new ArrayList<>();
            Arrays.fill(dist, 99999999);

            for(int i=0; i<d; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();

                arr[b].add(new Node(a, s));
            }

            PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
                public int compare(Node n1, Node n2){
                    return n1.time - n2.time;
                }
            });

            pq.add(new Node(c, 0));
            dist[c] = 0;
            while (!pq.isEmpty()){
                Node now = pq.poll();
                if(visited[now.num]) continue;
                visited[now.num] = true;
                for(Node next : arr[now.num]){
                    if(dist[next.num] > dist[now.num] + next.time){
                        dist[next.num] = dist[now.num] + next.time;
                        pq.add(new Node(next.num, dist[next.num]));
                    }
                }
            }

            int result = 0;
            int resultNum = 0;
            for(int i=1; i<=n; i++){
                if(dist[i]!=99999999) {
                    result = Math.max(result, dist[i]);
                    resultNum++;
                }
            }
            sb.append(resultNum).append(" ").append(result).append("\n");

        }

        System.out.print(sb);


    }

    static class Node{
        int num;
        int time;

        public Node(int n, int t){
            num = n;
            time = t;
        }
    }
}