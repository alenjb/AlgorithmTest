import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt(); //필요 나무 길이
        int [] trees = new int[N];

        for(int i=0; i<N; i++) trees[i] = sc.nextInt();

        long left = 0; //가능
        long right = 2_000_000_000; // 불가능
        while (left < right){
            long mid = (left + right + 1) / 2;
            if(check(mid, N, M, trees)){ //가능하면
                left = mid;
            }else{ //불가능하면
                right = mid - 1;
            }
        }
        System.out.println(left);

    }
    static boolean check(long num, int N, int M, int [] trees){
        long total = 0;
        for(int i=0; i<N; i++){
            total += Math.max(0, trees[i] - num);
        }
        return total >= M;
    }
}
