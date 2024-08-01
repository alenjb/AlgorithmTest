
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int [n+1];

        for(int i=1; i<=n; i++){
            arr[i] = i;
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            boolean result = true;

            if(a == 0){
                union(b,c);
            }else if(a == 1){
                if(checkSame(b, c)) bw.write("YES\n");
                else bw.write("NO\n");
            }

        }
        bw.flush();
    }

    private static void union(int b, int c) {
        int bb = find(b);
        int cc = find(c);

        if(bb != cc) arr[bb] = cc;
    }
    private static int find(int a) {
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
    private static boolean checkSame(int a, int b){
        a= find(a);
        b = find(b);
        return a==b;
    }

}
