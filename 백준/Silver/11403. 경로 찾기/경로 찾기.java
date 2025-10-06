import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean [][] dist = new boolean[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                int now = sc.nextInt();
                if(now == 1) dist[i][j] = true;
            }
        }

        for(int k=1; k<=N; k++){
            for(int s=1; s<=N; s++){
                for(int e=1; e<=N; e++){
                    if(dist[s][k] && dist[k][e]) dist[s][e] = true;
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                boolean now = dist[i][j];
                if(now) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }

    }
}
