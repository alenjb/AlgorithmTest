import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        int v = N / K; // 총 몇개의 바구니로 나뉘는지

        for(int i=0; i<K; i++){
            List<Integer> list = new LinkedList<>();
            for(int j=i * v; j<(i+1)*v;j++){
                list.add(arr[j]);
            }
            Collections.sort(list);
            for(int a : list) sb.append(a+" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}