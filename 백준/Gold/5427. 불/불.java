import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int N;
    static int h, w ,result;
    static char [][] map;
    static int [] sang; // r, c
    static List<int []> fire; // r, c
    static boolean [][] visited;
    static boolean [][] fireVisited;
    static int [] dr = {0, -1, 1, 0};
    static int [] dc = {-1, 0, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine()); // 테케 개수
        
        for(int i=0; i<N; i++){
            String [] line = br.readLine().split(" ");
            w = Integer.parseInt(line[0]);
            h = Integer.parseInt(line[1]);
            map = new char[h][w];
            visited = new boolean[h][w];
            fireVisited = new boolean[h][w];
            sang = new int [2];
            result = Integer.MAX_VALUE;
            fire = new ArrayList<>();

            for(int j=0; j<h; j++) {
                String now = br.readLine();
                for (int k = 0; k < w; k++) {
                    char c = now.charAt(k);
                    map[j][k] = c;
                    if (c == '@') sang = new int[]{j, k};
                    else if (c == '*') {
                        fire.add(new int[]{j, k});
                        fireVisited[j][k] = true;
                    }
                }
            }
            BFS();
            if(result == Integer.MAX_VALUE) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(result).append("\n");
            result = Integer.MAX_VALUE;
        }
        System.out.print(sb);
    }

    static void burn(){
        List<int []> nowList = new ArrayList<>();
        for(int [] pos : fire){
            int r = pos[0];
            int c = pos[1];

            for(int i=0; i<4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if(newR >=0 && newR < h && newC >=0 && newC < w){
                    if(map[newR][newC] == '.'){
                        map[newR][newC] = '*';
                        if(!fireVisited[newR][newC]){
                            nowList.add(new int[] {newR, newC});
                            fireVisited[newR][newC] = true;
                        }
                    }
                }
            }
        }
        fire = nowList;


//        for(int i=0; i<h; i++){
//            for(int j=0; j<w; j++){
//                if(fireVisited[i][j]) System.out.print(1+" ");
//                else System.out.print(0+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("=== = ");
    }

    static void BFS(){
        Queue<int []> q = new ArrayDeque<>();
        q.add(new int [] {sang[0], sang[1], 0});
        int stage = 1;
        while (!q.isEmpty()){
            int[] poll = q.poll();
            int r = poll[0];
            int c = poll[1];
            int cnt = poll[2];

            if(stage == cnt){
                burn();
                stage++;
            }

            if(visited[r][c]) continue;
            visited[r][c] = true;
            cnt++;

            if((map[r][c] == '.' || map[r][c]== '@')  && (r == 0 || r == h-1 || c ==0 || c == w-1 )){
//                System.out.println("r = " + r+" c: "+c);
                result = Math.min(cnt, result);
                return;
            }

            for(int i=0; i<4; i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if(newR >=0 && newR < h && newC >=0 && newC < w && map[newR][newC] == '.' && !visited[newR][newC]){
                   if(check(newR, newC)) {
//                       System.out.println("newC = " + newC + " newR: "+newR);
                       q.add(new int[]{newR, newC, cnt});
//                       System.out.println("newR+ \" \"+newC = " + newR + " " + newC);
                   }
                }
            }
        }
    }

    static boolean check(int r, int c){
        for(int i=0; i<4; i++){
            int newR = r + dr[i];
            int newC = c + dc[i];

            if(newR >=0 && newR < h && newC >=0 && newC < w){
                if(map[newR][newC] == '*') return false;
            }
        }
        return true;
    }
}