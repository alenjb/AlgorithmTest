import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int M = sc.nextInt();
        int [] arr2 = new int[M];
        for(int i=0; i<M; i++) arr2[i] = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int num : arr2){
            int left = 0;
            int right = N-1;
            boolean find = false;
            while (left <= right){
                int mid = (left + right) / 2;
                if(arr[mid] == num){
                    sb.append(1).append("\n");
                    find = true;
                    break;
                }else if(arr[mid] < num) left = mid +1;
                else right = mid-1;
            }
            if(!find) sb.append(0).append("\n");
        }

        System.out.print(sb.toString());
    }
}
