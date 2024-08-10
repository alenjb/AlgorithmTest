import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken()); // 만들 수
        int num = Integer.parseInt(st.nextToken()); // 더할 개수
        int [][] arr = new int[num+1][target+1]; // DP 배열 arr[i][j] -> i를 개를 더해서 j를 만들기

        //1개로 만드는 경우
        for(int i=0 ;i<=target; i++){
            arr[1][i] = 1; //1으로 초기화
        }

        // DP 적용
        for(int i=1; i<=num; i++){ // i개를 더해서
            for(int j=0; j<=target; j++){ // j를 만듦
                // arr[i][j] = arr[i-1]들 다 더하기
                for(int k = 0; k<=j; k++){
                    arr[i][j] = (arr[i][j] +  arr[i-1][j-k]) % 1_000_000_000;
                }
            }
        }

        bw.write(arr[num][target]+"");
        bw.flush();
        bw.close();
    }
}
