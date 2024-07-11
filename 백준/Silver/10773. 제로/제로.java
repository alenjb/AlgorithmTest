import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<k; i++){
            int n = sc.nextInt();
            if(n == 0) stack.pop();
            else stack.push(n);
        }
        
        int result = 0;
        while(!stack.isEmpty()) result+=stack.pop();
        
        System.out.println(result);
    }
}