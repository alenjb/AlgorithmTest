import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> []  arr = new List[N+1];
        for(int i=0; i<=N; i++) arr[i] = new ArrayList();
        int[] buildTime = new int[N+1];
        int [] totalTime = new int[N+1];

        int [] inDegree = new int[N+1];

        for(int i=1; i<=N; i++){
            buildTime[i] = sc.nextInt();
            while (true){
                int prev = sc.nextInt();
                if(prev == -1) break;
                else{
                    arr[prev].add(i);
                    inDegree[i]++;
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            totalTime[i] = buildTime[i];
            if(inDegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()){
            int poll = q.poll();
            for(int next : arr[poll]){
                inDegree[next]--;
                totalTime[next] = Math.max(totalTime[next], totalTime[poll] + buildTime[next]);
                if(inDegree[next] == 0) q.add(next);
            }
        }
        for(int i=1; i<=N; i++){
            System.out.println(totalTime[i]);
        }
    }
}
