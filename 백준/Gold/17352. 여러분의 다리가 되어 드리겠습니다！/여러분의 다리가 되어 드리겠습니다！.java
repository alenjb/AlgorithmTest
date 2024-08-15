import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 섬의 개수
        arr = new int[N+1];

        for(int i=1; i<N+1; i++) arr[i] = i;

        for(int i=0; i<N-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int parent = find(1);
        sb.append(1).append(" ");
        for(int i=1; i<N+1; i++){
            if(find(i)!= parent){
                sb.append(i).append(" ");
                break;
            }
        }

        for(int i= 1; i<N+1; i++){
            arr[i] = find(i);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void union(int a, int b){
        int aa = find(a);
        arr[aa] = find(b);
    }

    static int find(int num){
        if(arr[num]  == num) return num;
        return arr[num] = find(arr[num]);
    }
}