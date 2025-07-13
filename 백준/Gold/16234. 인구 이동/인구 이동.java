import java.util.*;
public class Main{
    static int [] dr = {0, -1, 0, 1};
    static int [] dc = {-1, 0, 1, 0};
    static int [][] arr;
    static int [][] arr2;
    static boolean [][] visited;
    static int N, L, R;
    static int answer = 0;
    static HashMap<Integer, Integer> count = new HashMap<>();
    static HashMap<Integer, Integer> sum = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        arr = new int[N][N];
        arr2 = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        while (true){
            // L <= <= R 두 나라가 국경을 염 -> DFS로 1~ k까지 만들기
            int num = 1;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]) {
                        DFS(i, j, num);
                        num++;
                    }
                }
            }
            if(num == N * N + 1){
                System.out.println(answer);
                return;
            }

            answer++;
            visited = new boolean[N][N];

            // 연합을 다 구하기
            // 연합끼리 인구수 같게 하기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr2[i][j] != 0){
                        int now = arr2[i][j];
                        arr[i][j] = sum.get(now) / count.get(now);
                    }
                }
            }

            count = new HashMap<>();
            sum = new HashMap<>();

        }
    }

    static void DFS(int r, int c, int num){
        if(visited[r][c]) return;

        visited[r][c] = true;
        arr2[r][c] = num;
        count.put(num, count.getOrDefault(num, 0) + 1);
        sum.put(num, sum.getOrDefault(num, 0) + arr[r][c]);
        for(int i=0; i<4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            if(newR>=0 && newR <N && newC>=0 && newC <N && !visited[newR][newC]
                && Math.abs(arr[newR][newC] - arr[r][c]) >=L && Math.abs(arr[newR][newC] - arr[r][c]) <= R
            ){
                DFS(newR, newC, num);
            }
        }
    }
}