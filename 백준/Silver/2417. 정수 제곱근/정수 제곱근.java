import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long result = (long)Math.ceil(Math.sqrt(num));
        if(Math.pow(result, 2) >= num) System.out.println(result);
        else System.out.println(result+1);
    }
}