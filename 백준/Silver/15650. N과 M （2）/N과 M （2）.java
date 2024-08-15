import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean [] visited;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];
        dfs(N,M,0);
        bw.write(sb.toString());
        bw.flush();



    }
    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!visited[i] && (depth == 0 || i+1 > arr[depth-1])){
                visited[i] = true;
                arr[depth] = i+1;
                dfs(N, M, depth+1);
                visited[i] = false;
            }
        }

    }
}