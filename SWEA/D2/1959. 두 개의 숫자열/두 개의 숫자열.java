import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
            int maxInt = Math.max(n, m);
            int minInt = Math.min(n, m);

            int [] arrN = new int [n];
            int [] arrM = new int [m];
            for(int i=0; i<n; i++){
            	arrN[i] = sc.nextInt();
            }
            for(int i=0; i<m; i++){
            	arrM[i] = sc.nextInt();
            }
            int result = cal(maxInt, minInt, arrN, arrM);
            System.out.println("#"+test_case + " "+result);
		}
	}
    public static int cal(int maxNum, int minNum, int [] arrN, int [] arrM){
    	int result = 0;
        // n이 더 작은 경우
        if(minNum == arrN.length){
        	for(int j=0; j<=maxNum- minNum; j++){
                int num = 0;
                for(int i=0; i<minNum; i++){
                    num = num + arrN[i] * arrM[i+j];
         	   }
                if(num > result) result = num;
            }
        }else{ // m이 더 작은 경우
            for(int j=0; j<=maxNum- minNum; j++){
                int num = 0;
                for(int i=0; i<minNum; i++){
                    num = num + arrM[i] * arrN[i+j];
                }
                if(num > result) result = num;
            }
        }
        return result;
    }
}