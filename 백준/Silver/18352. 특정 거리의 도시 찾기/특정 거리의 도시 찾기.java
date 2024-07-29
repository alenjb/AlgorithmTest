import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<Integer> [] arr = new ArrayList[n+1];
        int [] result = new int[n+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        // 초기화
        for(int i=0; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        // 저장
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }

        Queue<Node> q = new LinkedList<>();
        Node startNode = new Node(0, x);
        q.add(startNode);
        while(!q.isEmpty()) {
            Node poll = q.poll();
            // 방문 했으면
            if(result[poll.num] != Integer.MAX_VALUE) continue;
            else{
                // 최단거리 업데이트
                if(result[poll.num] > poll.depth) result[poll.num] = poll.depth;
            }
            // 깊이가 다른데 depth가 아직 얕으면
            if(poll.depth < k) {
                for(int i=0; i<arr[poll.num].size(); i++) {
                    q.offer(new Node(poll.depth+1, arr[poll.num].get(i)));
                }
            }
            //깊이가 다른데 depth가 크면 다시 넣지 않음
        }
        boolean hasResult = false;
        for(int i=0; i<result.length; i++){
            if(result[i] == k) {
                bw.write(i+"\n");
                hasResult = true;
            }
        }
        if(!hasResult) bw.write("-1\n");
        bw.flush();

    }
    static class Node{
        int depth;
        int num;
        public Node(int depth, int num) {
            this.depth = depth;
            this.num = num;
        }
    }
}
