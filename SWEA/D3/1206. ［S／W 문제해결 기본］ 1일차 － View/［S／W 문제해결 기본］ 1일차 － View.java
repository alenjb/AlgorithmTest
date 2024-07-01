import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static int [] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            int testCase = Integer.parseInt(br.readLine());
            arr = new int[testCase];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<testCase; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int check = check();
            bw.write("#"+(i+1)+" "+check+"\n");
        }
        bw.flush();
    }
    public static int check(){
        int result = 0;
        for(int i=2; i<arr.length-2; i++){
            int a = arr[i-2];
            int b = arr[i-1];
            int c = arr[i+1];
            int d = arr[i+2];
            int left = Math.max(a, b);
            int right = Math.max(c, d);
            int count = arr[i] - Math.max(left, right);
            if(count>0) {
                result+=count;
            }
        }
        return result;
    }
}
