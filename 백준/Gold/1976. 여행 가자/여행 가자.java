import java.util.*;
import java.io.*;

public class Main {
    static int [] parent;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 총 도시 수
        parent = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 여행 계획 도시 수

        for(int i=0; i<n+1; i++) parent[i] = i;

        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<n+1; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1 && i!=j) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        for(int i=1; i<m; i++){
            int now = Integer.parseInt(st.nextToken());
            if(find(prev) != find(now)) {
                System.out.println("NO");
                return;
            }
            prev = now;
        }
        System.out.println("YES");

    }
    public static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa != bb){
            parent[aa] = bb;
        }
    }

    public static int find(int num){
        if(parent[num] != num) return parent[num] = find(parent[num]);
        return num;
    }
}
