import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int [] team;
    static List<Integer> [] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new List[N+1];
        team = new int[N+1];
        visited = new boolean[N+1];
        Arrays.fill(team, 1); // 1과 -1로 구분
        for(int i=1; i<=N; i++) arr[i] = new ArrayList<>();


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            for(int k=0; k<total; k++){
                int dislike = Integer.parseInt(st.nextToken());
                arr[i].add(dislike);
                arr[dislike].add(i);
            }
        }

        team[1] = 1;
        for(int i=1; i<=N; i++){
            if(!visited[i]) DFS(i, team[i]);
        }

        int firstTeam = 0;
        for(int i=1; i<=N; i++){
            if(team[i] == 1) firstTeam++;
        }
        sb.append(firstTeam).append("\n");

        int secondTeam = N - firstTeam;
        for(int i=1; i<=N; i++){
            if(team[i] == 1) sb.append(i).append(" ");
        }
        sb.append("\n");

        sb.append(secondTeam).append("\n");
        for(int i=1; i<=N; i++){
            if(team[i] == -1) sb.append(i).append(" ");
        }

        System.out.print(sb);


    }
    static void DFS(int num, int nowTeam){
        visited[num] = true;
        for(int n : arr[num]){
            if(!visited[n]) {
                team[n] = - nowTeam;
                DFS(n, - nowTeam);
            }
        }
    }
}