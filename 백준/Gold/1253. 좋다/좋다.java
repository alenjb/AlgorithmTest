import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int answer = 0;

        // 가능한 조합 set
        for(int w=0; w<n; w++){
            int want = arr[w];
            int i = 0;
            int j = n-1;
            while (i < j){
                if(i == w){
                    i++;
                    continue;
                }
                else if(j == w){
                    j--;
                    continue;
                }
                int now = arr[i] + arr[j];
                if(now == want){
                    answer++;
                    break;
                }else if(now < want) i++;
                else j--;
            }
        }
        System.out.println(answer);
    }
}