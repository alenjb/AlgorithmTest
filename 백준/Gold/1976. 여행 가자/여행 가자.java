import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    static int [] plan;
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        plan = new int[M+1];
        // 배열 초기화
        for(int i=0; i<N+1; i++){
            arr[i] = i;
        }
        // 연결 정보 입력
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 계획 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<M+1; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 여행 계획 검사
        for(int i=1; i<M; i++){
            if(find(plan[i]) != find(plan[i+1])){
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }
        bw.write("YES");
        bw.flush();
        bw.close();

    }
    static void union(int a, int b){
        int g1 = find(a);
        int g2 = find(b);
        //작은게 대표
        if(g1 > g2) arr[g1] = g2;
        else if(g2 > g1) arr[g2] = g1;
    }
    static int find(int num){
        if(arr[num]!= num){
            arr[num] = find(arr[num]);
        }
        return arr[num];
    }
}
