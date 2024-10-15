import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Long.parseLong(br.readLine());
        long result = bs(0, num);
        System.out.println(result);


    }
    // start는 -1 unchecked, end는 checked
    static long bs(long start, long end){
        long mid = 0;
        while (start <= end){
            mid = (start + end) / 2;
            if(check(mid)) end = mid-1;
            else start = mid +1;
        }
        return start;
    }
    static boolean check(long now){
        return Math.pow(now, 2) >= num;
    }
}