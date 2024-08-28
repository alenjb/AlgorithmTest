import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//2시 58분
public class Solution {
    static int [] parent;
    static int N, M;
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            set = new HashSet<>();
            parent = new int[N+1];
            for(int i=1; i<=N; i++) parent[i] = i;
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                union(num1, num2);
            }
            for(int i=1; i<=N; i++){
                parent[i] = find(i);
                set.add(parent[i]);
            }
            sb.append("#").append(tc).append(" ").append(set.size()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        if(aa == bb) return;
        parent[aa] =bb;
    }
    static int find(int num){
        if(num== parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
}