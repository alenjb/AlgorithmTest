import java.util.*;
public class Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] arr = new int [num];
        for(int i=0;i<num;i++){
            int n1 = sc.nextInt();
            arr[i] = n1;
        }
        Arrays.sort(arr);
        int answer = 0;

        // 각각 대상이 되며
        for(int i=0; i<num; i++){
            int left = 0;
            int right = num-1;

            while(left <right){
                int lN = arr[left];
                int rN = arr[right];
                int sum = lN + rN;
                if(sum == arr[i]){
                    if(left == i){
                        left++;
                    }else if(right == i){
                        right--;
                    }else {
                        answer++;
                        break;
                    }

                }else if(sum < arr[i]){
                    left++;
                }else right--;
            }
        }
        System.out.println(answer);
    }

}