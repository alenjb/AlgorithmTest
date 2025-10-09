import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();

        List<List<Integer>> sub = subset(n, arr);
        int answer = 0;
        for(List<Integer> list  : sub){
            int num = 0;
            for(int nums : list) num+= nums;
            if(num == s) answer++;
        }
        if(s == 0) answer--;
        System.out.println(answer);
    }

    static List<List<Integer>> subset(int n, int [] arr){
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(n, arr, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void backTrack(int n, int [] arr, int start, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i=start; i<n; i++){
            curr.add(arr[i]);
            backTrack(n, arr, i+1, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}
