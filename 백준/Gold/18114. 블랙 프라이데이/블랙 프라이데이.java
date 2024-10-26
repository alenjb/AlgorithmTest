import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건개수
        int C = Integer.parseInt(st.nextToken()); // 무게
        int [] arr = new int[N];
        Set<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
            set.add(now);
            // 1개 짜리
            if(C == now) {
                System.out.println(1);
                return;
            }
        }

        // 2개 짜리
        for(int i=0; i<N; i++){
            int now = arr[i];
            int need = C - now;
            if(now!=need && set.contains(need)){
                System.out.println(1);
                return;
            }
        }

        // 3개 짜리
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int num1 = arr[i];
                int num2 = arr[j];
                int sum = num1 + num2;
                int need = C - sum;
                if(need == num1 || need == num2) continue;
                if(set.contains(need)){
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}