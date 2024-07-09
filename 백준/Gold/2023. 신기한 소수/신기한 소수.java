import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    //2 ~ 마지막 자리 1,3,7,9
    static int [] available = {1,3,7,9};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());

        // 첫자리 2,3,5,7,9
        int [] first = {2,3,5,7,9};
        // 첫째 자리에 가능한 숫자들부터 DFS
        for(int k: first){
            dfs(n, k);
        }
        bw.write(sb.toString());
        bw.flush();
    }

    private static void dfs(int depth, int num) {
        if(depth == 1) {
            if(prime(num)) sb.append(num+"\n");
        }
        else {
            if(prime(num)){
                for(int i : available){
                    int newNum = num * 10 + i;
                    dfs(depth-1, newNum);
                }

            }
        }

    }

    private static boolean prime(int num)
    {
        for(int i=2; i<=Math.sqrt(num); i++){
                if(num % i ==0) return false;}
        return true;
    }
}
