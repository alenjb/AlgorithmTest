import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;
    static int N, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new long[N];

        for(int i=0; i<N; i++) arr[i] = Long.parseLong(br.readLine());
        Arrays.sort(arr);

        long result = bs(1, arr[N-1] - arr[0]+1);
        System.out.println(result);


    }

    private static long bs(long left, long right) {
        while(left+1 < right){
            long mid = (left + right) / 2;
            int possibleCnt = possible(mid);
            if(possibleCnt < C){ // 만족하지 않는 경우
                right = mid;
            }else{ // 만족하는 경우
                left = mid;
            }
        }
        return left;
    }
    static int possible(long dist){
        long last = arr[0];
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(arr[i] >= last + dist) {
                last = arr[i];
                cnt++;
            }
        }
        return cnt;
    }
}