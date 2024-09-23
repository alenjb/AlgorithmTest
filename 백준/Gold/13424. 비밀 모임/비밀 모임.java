import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long [][] dist;
    static int [] friends;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 방의 개수
            dist = new long[N+1][N+1];
            M = Integer.parseInt(st.nextToken()); // 비밀 통로의 개수

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(i == j) dist[i][j] = 0;
                    else dist[i][j] = 123456789;
                }
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                dist[start][end] = weight;
                dist[end][start] = weight;
            }

            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            friends = new int[K];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                friends[i] = Integer.parseInt(st.nextToken());
            }


            //플로이드 워셜 K S E
            for(int k=1; k<=N; k++){
                for(int s=1; s<=N; s++){
                    for(int e=1; e<=N; e++){
                        if(dist[s][k] != 123456789 && dist[k][e] != 123456789){
                            dist[s][e] = Math.min(dist[s][k] + dist[k][e], dist[s][e]);
                        }
                    }
                }
            }

            long minSum = Long.MAX_VALUE;
            int result = 0;

            for(int i=1; i<=N; i++){
                long sum = 0;
                for(int j=0; j<K; j++){
                    sum += dist[friends[j]][i];
//                    if(friends[j] == i)continue outer;
                }
                if(minSum > sum){
                    minSum = sum;
                    result = i;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}