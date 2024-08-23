import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    static int H, W;
    static char [][] arr;
    static int [] nowLoc = new int[2]; //0: i 1: j
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc<=T ;tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            arr = new char[H][W];
            for(int i=0; i<H; i++){
                String line  = br.readLine();
                for(int j=0; j<W; j++){
                    arr[i][j] = line.charAt(j);
                    if(line.charAt(j) == '<' || line.charAt(j) == '>' ||
                            line.charAt(j) == '^' || line.charAt(j) == 'v'){
                        nowLoc[0]= i;
                        nowLoc[1] = j;
                    }
                }
            }

            int inputLength = Integer.parseInt(br.readLine());

            String line = br.readLine();
            for(int i=0; i<inputLength; i++){
                char input = line.charAt(i);
                move(input, nowLoc);
            }

            sb.append("#").append(tc).append(" ");
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void move(char input, int [] nowLoc) {
        int y = nowLoc[0];
        int x = nowLoc[1];
        switch (input){
            case 'U':
                if(check(x, y-1) && arr[y-1][x] == '.'){
                    arr[y][x] = '.';
                    arr[y-1][x] = '^';
                    nowLoc[0] = y-1;
                }else{
                    arr[y][x] = '^';
                }
                break;
            case 'D':
                if(check(x, y+1) && arr[y+1][x] == '.'){
                    arr[y][x] = '.';
                    arr[y+1][x] = 'v';
                    nowLoc[0] = y+1;
                }else{
                    arr[y][x] = 'v';
                }
                break;
            case 'L':
                if(check(x-1, y) && arr[y][x-1] == '.'){
                    arr[y][x] = '.';
                    arr[y][x-1] = '<';
                    nowLoc[1] = x-1;
                }else{
                    arr[y][x] = '<';
                }
                break;
            case 'R':
                if(check(x+1, y) && arr[y][x+1] == '.'){
                    arr[y][x] = '.';
                    arr[y][x+1] = '>';
                    nowLoc[1] = x+1;

                }else{
                    arr[y][x] = '>';
                }
                break;
            case 'S':
                shoot(x, y, arr[y][x]);
                break;
        }
    }
    static boolean check(int x, int y){
        return x>=0 && x<W && y>=0 && y<H;
    }
    static void shoot(int newX, int newY, char direction){
        while (check(newX, newY)){
            if(arr[newY][newX] == '*') {
                arr[newY][newX] = '.';
                return;
            }
            if(arr[newY][newX] == '#') {
                return;
            }
            switch (direction){
                case '^':
                    newY--;
                    break;
                case 'v':
                    newY++;
                    break;
                case '>':
                    newX++;
                    break;
                case '<':
                    newX--;
                    break;
            }
        }
    }
}