import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        Node [] items = new Node[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가치
            items[i] = new Node(W, V);
        }

        int [][] dp = new int[N+1][K+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                if(j-items[i].w >=0){
                    dp[i][j] = Math.max(dp[i-1][j-items[i].w] + items[i].v, dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][K]);

    }
    static class Node{
        int w;
        int v;

        public Node(int w, int v){
            this.w = w;
            this.v = v;
        }
    }
}