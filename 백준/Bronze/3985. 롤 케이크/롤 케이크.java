import java.util.*;
public class Main{
    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int people = sc.nextInt();
        int [] arr = new int [length];
        int [][] get = new int [people][2];
        int expect = 0;
        int expectP=0;
        for(int i=0; i<people; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            get[i][0] = end - start;
            if(expect < get[i][0]){
                expect = get[i][0];
                expectP = i+1;
            }
            for(int j=start-1; j<end; j++){
                if(arr[j]==0) {
                    get[i][1]++;
                    arr[j]=1;
                }
            }
        }
        int max = -1;
        int maxP = 0;
        for(int i=0; i<people; i++){
            if(max<get[i][1]){
                max = get[i][1];
                maxP = i+1;
            }
        }
        System.out.println(expectP);
        System.out.println(maxP);

    }
}