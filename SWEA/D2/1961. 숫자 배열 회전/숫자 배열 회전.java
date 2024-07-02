import java.util.Scanner;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            //1. 배열 저장
			int n = sc.nextInt();
            int [][] arr = new int [n][n];
            for(int i=0; i<n; i++){
            	for(int j=0; j<n; j++){
                	arr[i][j] = sc.nextInt();
                }
            }

            //2. 90도 회전
            int [][] arr90 =  new int [n][n];
            for(int i=0; i<n ;i++){
	            for(int j=0; j<n ;j++){
                    arr90[i][j] = arr[n-j-1][i];
                }
            }
            
            //3. 180도 회전
            int [][] arr180 =  new int [n][n];
            for(int i=0; i<n ;i++){
	            for(int j=0; j<n ;j++){
                    arr180[i][j] = arr[n-i-1][n-j-1];
                }
            }
            
            //4. 270도 회전
            int [][] arr270 =  new int [n][n];
            for(int i=0; i<n ;i++){
	            for(int j=0; j<n ;j++){
                    arr270[i][j] = arr[j][n-i-1];
                }
            }
            
            //5. 출력
            bw.write("#"+test_case+"\n");
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
		            bw.write(arr90[i][j]+"");			
                }
                bw.write(" ");

                for(int j=0; j<n; j++){
		            bw.write(arr180[i][j]+"");			
                }
                bw.write(" ");

                for(int j=0; j<n; j++){
                    bw.write(arr270[i][j]+"");			
                }
                bw.write("\n");
            }
		}
        bw.flush();
	}
}