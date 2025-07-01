import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int left = 0;
        int right = n - 1;
        int close = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < close) {
                close = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum > 0) right--;
            else left++;
        }

        System.out.println(ans1 + " " + ans2);

    }
}