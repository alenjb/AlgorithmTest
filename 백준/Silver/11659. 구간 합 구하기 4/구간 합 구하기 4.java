import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long [] sums = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
                sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf (sums[last] - sums[first-1])+"\n");
        }
        bw.flush();
    }
}