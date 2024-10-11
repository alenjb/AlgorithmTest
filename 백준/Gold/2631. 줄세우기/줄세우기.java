import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int [] arr, dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(dp, 1);

        //LIS 찾기
        calculate();
        int maxVal = 0;
        for(int i=0; i<N; i++){
            maxVal = Math.max(maxVal, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(N - maxVal);
    }

    private static void calculate() {
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }
    }
}