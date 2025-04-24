import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수 ( 1~N)
        int M = Integer.parseInt(st.nextToken()); // 비교회수

        List<Integer> [] arr = new List[N+1];
        for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();
        int [] inDegree = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 큰사람
            int b = Integer.parseInt(st.nextToken()); // 작은사람
            arr[a].add(b);
            inDegree[b]++;
        }

        Queue<Integer> pq = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0) pq.add(i);
        }

        while (!pq.isEmpty()){
            int num = pq.poll();
            for(int nn : arr[num]){
                inDegree[nn]--;
                if(inDegree[nn] == 0) pq.add(nn);
            }
            System.out.print(num + " ");
        }
    }
}
