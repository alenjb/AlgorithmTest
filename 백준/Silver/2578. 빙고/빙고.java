import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{
    static boolean [][] board = new boolean[5][5];
    static int [][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new int[5][5];
        int answer = 1;
        // 보드판 완성
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                putNum(Integer.parseInt(st.nextToken()));
                int total = calCross() + calWidth() + calLength();
                if(total >=3){
                    bw.write(answer+"\n");
                    bw.flush();
                    return;
                }
                answer++;
            }
        }


    }
    public static void putNum(int num){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(arr[i][j] == num) {
                    board[i][j] = true;
                    break;
                }
            }
        }
    }

    public static int calWidth(){
        int count = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(!board[i][j]) break;
                else if(j==4) count++;
            }
        }
        return count;
    }
    public static int calLength(){
        int count = 0;
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(!board[j][i]) break;
                else if(j==4) count++;
            }
        }
        return count;
    }
    public static int calCross(){
        int count = 0;
            for(int i=0, j=0; i<5 && j<5; i++, j++){
                if(!board[j][i]) break;
                else if(j==4) count++;
            }
        for(int i=0, j=4; i<5 && j>=0; i++, j--){
            if(!board[j][i]) break;
            else if(j==0) count++;
        }
        return count;
    }
}