import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L, C;
    static char [] arr;
    static List<Character> mos = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        for(int i=0; i<C; i++) arr[i] = sc.next().charAt(0);
        Arrays.sort(arr);

        dfs(0, 0, new StringBuilder());
        System.out.println(sb);
    }

    static void dfs(int start, int jaCount, StringBuilder curr){
        if(curr.length() == L){
            int moCount = L - jaCount;
            if(moCount >=1 && jaCount >=2){
                sb.append(curr.toString()).append("\n");
            }
            return;
        }

        for(int i=start; i<C; i++){
            curr.append(arr[i]);
            if(mos.contains(arr[i])) dfs(i+1, jaCount, curr);
            else dfs(i+1, jaCount+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
