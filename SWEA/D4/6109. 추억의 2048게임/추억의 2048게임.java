import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution {
    static int [][] arr;
    static int [][] arr2;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            arr = new int [N][N];
            arr2 = new int [N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            move(d);
            sb.append("#").append(tc).append("\n");
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    sb.append(arr2[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void move(String d){
        // 스택에 넣기
        Stack<Node1> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        switch (d){
            case "right":
                for(int i=0; i<N; i++){
                    for(int j=N-1; j>=0; j--){
                        if(arr[i][j] == 0) continue;
                        stack.add(new Node1(arr[i][j], false));
                    }
                    //스택에서 빼기
                    stackToList(stack, list);

                    int idx = list.size()-1;
                    for(int k=N-1; idx>=0; k--){
                        arr2[i][k] = list.get(idx--);
                    }
                    list.clear();
                }
                break;

            case "left":
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(arr[i][j] == 0) continue;
                        stack.add(new Node1(arr[i][j], false));
                    }
                    //스택에서 빼기
                    stackToList(stack, list);

                    int idx = list.size()-1;
                    for(int k=0; idx>=0; k++){
                        arr2[i][k] = list.get(idx--);
                    }
                    list.clear();
                }
                break;

            case "up":
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(arr[j][i] == 0) continue;
                        stack.add(new Node1(arr[j][i], false));
                    }
                    //스택에서 빼기
                    stackToList(stack, list);

                    int idx = list.size()-1;
                    for(int k=0; k<list.size(); k++){
                        arr2[k][i] = list.get(idx--);
                    }
                    list.clear();
                }
                break;

            case "down":
                // 스택에 넣기
                for(int i=0; i<N; i++){
                    for(int j=N-1; j>=0; j--){
                        if(arr[j][i] == 0) continue;
                        stack.add(new Node1(arr[j][i], false));
                    }
                    //스택에서 빼기
                    stackToList(stack, list);

                    int idx = list.size()-1;
                    for(int k=N-1; idx>=0; k--){
                        arr2[k][i] = list.get(idx--);
                    }
                    list.clear();
                }
                break;



        }
    }

    private static void stackToList(Stack<Node1> stack, List<Integer> list) {
        while (!stack.isEmpty()){
            Node1 pop = stack.pop();
            if(stack.isEmpty()) {
                list.add(pop.num);
                break;
            }
            Node1 peek = stack.peek();
            if(pop.num == peek.num && !pop.isModified && !peek.isModified) {
                int cnt = 1; // 현재 num이 있으므로
                while(stack.size()>0 && stack.peek().num == pop.num){
                    stack.pop();
                    cnt++;
                }
                int plusNum = cnt /2;
                int remain = cnt % 2;
                if(remain==1) list.add(pop.num);
                for(int m=0; m<plusNum; m++) list.add(pop.num*2);
            }
            else list.add(pop.num); // 더이상 합칠 수 없으면 리스트에 저장 (0번째 인덱스에 저장된게 제일 마지막에 출력)
        }
    }

}
class Node1{
    int num;
    boolean isModified;

    public Node1(int num, boolean able) {
        this.num = num;
        this.isModified = able;
    }
}