import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long [] arr = new long [n];
        Map<Long, Long> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<n; i++){
            map.put(arr[i], (long)i);
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());
            if(map.get(num)!=null){
                long j = map.get(num);
                sb.append(j * (n-1 -j)).append("\n");

            }else{                
                sb.append("0").append("\n");
            }
        }

        System.out.print(sb);
        
        
        
    }
}
