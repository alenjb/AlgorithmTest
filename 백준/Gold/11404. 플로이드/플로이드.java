import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long [][] dist = new long[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j )dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int k = sc.nextInt();
            if(dist[s][e] > k) dist[s][e] = k;
        }

        for(int k=1; k<=n; k++){
            for(int s=1; s<=n; s++){
                for(int e=1; e<=n; e++){
                    if(dist[s][e] > dist[s][k] + dist[k][e]) dist[s][e] = dist[s][k] + dist[k][e];
                }
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(dist[i][j] == Integer.MAX_VALUE) System.out.print("0"+" ");
                else System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }

    }
}