import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static int [] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            for(int i=1; i<=n; i++) parent[i] = i;

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(st.nextToken());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if(cal==0) union(num1, num2);
                else if (cal ==1) {
                    sb.append(isFamily(num1, num2));
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa == bb) return;
        parent[aa] = bb;
    }
    static int find(int num){
        if(num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
    static int isFamily(int num1, int num2){
        if(find(num1) == find(num2)) return 1;
        return 0;
    }
}