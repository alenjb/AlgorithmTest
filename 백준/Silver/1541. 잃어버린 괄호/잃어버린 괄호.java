import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        String[] parts = input.split("-");
        int total = addAll(parts[0]);
        
        for (int i = 1; i < parts.length; i++) {
            total -= addAll(parts[i]);
        }
        System.out.println(total);
    }

    public static int addAll(String s) {
        StringTokenizer st = new StringTokenizer(s, "+");
        int total = 0;
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }
        return total;
    }

}