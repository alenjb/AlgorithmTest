import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char [] [] arr;
    static int [] dx = {1, 0, -1, 0};//우 하 좌 상
    static int [] dy = {0, 1, 0, -1};
    static int result;
    static int R;
    static int C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R+1][C+1];
        boolean [] visited = new boolean[26]; // 알파벳 배열

        for(int i=1; i<=R; i++){
            String line = br.readLine();
            for(int j=1; j<=C; j++){
                arr[i][j] = line.charAt(j-1);
            }
        }
        bfs(1,1,1,visited);
        bw.write(result+"\n");
        bw.flush();



    }
    static void bfs(int x, int y, int count, boolean [] visited){
        int ch = arr[y][x];
        int val = ch -65;
        if(visited[val]) return;
        boolean [] visit = Arrays.copyOf(visited, visited.length);

        visit[val] = true;
        if(count> result) {
            result = count;
        }
        for(int i=0; i<4; i++){
            int nowx = x+dx[i];
            int nowy = y+dy[i];
            if(nowy>=1 && nowx>=1 && nowx<=C && nowy <=R){
                bfs(nowx, nowy, count+1, visit);
            }
        }
    }
}
