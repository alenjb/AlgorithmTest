import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> [] arr;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int M = sc.nextInt();
            int start = sc.nextInt();

            arr = new List[N+1];
            visited = new boolean[N+1];
            for(int i=1; i<=N; i++) arr[i] = new ArrayList<Integer>();


            for(int i=0; i<M; i++){
                int s = sc.nextInt();
                int e = sc.nextInt();
                arr[s].add(e);
                arr[e].add(s);
            }

            for(int i=1; i<=N; i++) Collections.sort(arr[i]);

        //DFS
            DFS(start);
            sb.append("\n");

            //BFS
            visited = new boolean[N+1];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(start);
            visited[start] = true;
            while (!q.isEmpty()){
                int now = q.poll();
                sb.append(now).append(" ");
                for(int next : arr[now]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        System.out.println(sb.toString());
    }
    static public void DFS(int now){
        sb.append(now).append(" ");
        visited[now] = true;
        for(int next : arr[now]){
            if(!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}
