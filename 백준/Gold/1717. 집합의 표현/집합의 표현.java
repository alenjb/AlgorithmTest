import java.util.*;
import java.io.*;

public class Main {
    static int [] parent;
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cal == 0){ // 합집합
                union(a, b);
            } else if (cal == 1) { // 조회
                int aa = find(a);
                int bb = find(b);
                if (aa == bb) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static void union(int a, int b){
        int aa = find(parent[a]);
        int bb = find(parent[b]);
        if(aa != bb){
            parent[aa] = bb;
        }
    }

    public static int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}
