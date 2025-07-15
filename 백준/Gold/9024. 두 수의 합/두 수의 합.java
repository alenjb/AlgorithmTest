import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int left = 0;
            int right = arr.length-1;
            int min = Integer.MAX_VALUE;
            int cnt = 0;
            while(left<right){
                int sum = arr[left]+arr[right];
                int diff = Math.abs(sum-k);
                if(diff < min){
                    min = diff;
                    cnt = 1;
                }else if(diff == min){
                    cnt++;
                }

                if(sum<k){
                    left++;
                }else{
                    right--;
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
    }
}