import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        int [] result = new int[N];
        int [] nearest = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(nearest, -1);

        Stack<Integer> stack = new Stack<>();

        //왼 -> 오 :왼쪽에 보이는거 탐색
        for(int i=0; i<N; i++){
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] <= num){
                stack.pop();
            }
            result[i] += stack.size();
            if(!stack.isEmpty()){
                int leftNearest = stack.peek();
                nearest[i] = leftNearest;
            }
            stack.push(i);
        }

        stack.clear();
        
        //왼 <- 오 :오른쪽에 보이는거 탐색
        for(int i=N-1; i>=0; i--){
            int num = arr[i];
            while (!stack.isEmpty() && arr[stack.peek()] <= num){
                stack.pop();
            }
            result[i] += stack.size();
            if(!stack.isEmpty()){
                int leftNearest = nearest[i];
                int rightNearest = stack.peek();
                if((i - leftNearest) > (rightNearest - i)){
                    nearest[i] = rightNearest;
                } else if (nearest[i]==-1) {
                    nearest[i] = rightNearest;
                }
            }
            stack.push(i);
        }

        for(int i=0; i<N; i++){
            sb.append(result[i]);
            if(result[i]!=0) sb.append(" ").append(nearest[i]+1);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}