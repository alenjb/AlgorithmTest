import java.util.*;
import java.io.*;

class Main {
    public static int [][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        F [] arr = new F[N];
        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            F f = new F(a, b);
            arr[i] = f;
        }
        Arrays.sort(arr);
        for(F f : arr){
            bw.write(f.a + " " + f.b+"\n");
        }
        bw.flush();

    }

}
class F implements Comparable<F>{
    int a, b;

    public F(int a, int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public int compareTo(F o) {
        if(this.a < o.a) return -1;
        else if (this.a > o.a) return 1;
        else {
            if(this.b<o.b) return -1;
            return 1;
        }
    }
}
