import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException   {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int input;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input>0) {
                minQueue.add(input);
            } else {
                if (!minQueue.isEmpty()) {
                    System.out.println(minQueue.poll());
                }
                else{
                    System.out.println(0);
                }
            }
        }
        br.close();
    }
}