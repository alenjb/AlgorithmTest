import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    static int n, start;
    static List<Integer> [] arr;
    static boolean [] visited;
    static Queue<Node6> q = new ArrayDeque<>();
    static int [] maxDepth;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            arr = new List[101];
            visited = new boolean[101];
            maxDepth = new int[101];

            for(int i=1; i<=100; i++) arr[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n/2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                arr[from].add(to);
            }
            q.add(new Node6(start, 0));
            int result = BFS();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int BFS(){
        while (!q.isEmpty()){
            Node6 poll = q.poll();
            if(visited[poll.num]) continue;
            visited[poll.num] = true;
            maxDepth[poll.depth] = Math.max(maxDepth[poll.depth], poll.num);
            for(int n : arr[poll.num]) if(!visited[n]) q.add(new Node6(n, poll.depth+1));
            if(q.isEmpty()) return maxDepth[poll.depth];
        }
        return -1;
    }
}
class Node6{
    int num;
    int depth;
    public Node6(int num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}