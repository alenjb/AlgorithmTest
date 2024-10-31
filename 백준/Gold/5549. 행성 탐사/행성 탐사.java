import java.util.*;
import java.io.*;
public class Main {
    static int N, M, K;
    static char [][] map;
    static Ground [][] resultMap;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        resultMap = new Ground[N][M];

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken()); // 조사 대상 영역 개수

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = line.charAt(j);
            }
        }

        // 0,0
        char c = map[0][0];
        if(c == 'J') resultMap[0][0] = new Ground(1,0,0);
        else if(c == 'O') resultMap[0][0] = new Ground(0,1,0);
        else if(c == 'I') resultMap[0][0] = new Ground(0,0,1);

        // 1행 채우기
        for(int a=1; a<M; a++){
            int i;
            int j;
            int o;
            Ground prev = resultMap[0][a - 1];
            i = prev.i;
            j = prev.j;
            o = prev.o;

            char now = map[0][a];
            if(now == 'J') j++;
            else if(now == 'O') o++;
            else if(now == 'I') i++;
            resultMap[0][a] = new Ground(j,o,i);
        }

        // 1열 채우기
        for(int a=1; a<N; a++){
            int i;
            int j;
            int o;
            Ground prev = resultMap[a-1][0];
            i = prev.i;
            j = prev.j;
            o = prev.o;

            char now = map[a][0];
            if(now == 'J') j++;
            else if(now == 'O') o++;
            else if(now == 'I') i++;
            resultMap[a][0] = new Ground(j,o,i);
        }



        // 이후 채우기
        for(int ii=1; ii<N; ii++){
            for(int jj=1; jj<M; jj++){
                int i = 0;
                int j = 0;
                int o = 0;

                // 위에꺼 더하기
                Ground up = resultMap[ii-1][jj];
                // 왼쪽꺼 더하기
                Ground left = resultMap[ii][jj-1];
                // 중복 빼기
                Ground cross = resultMap[ii-1][jj-1];

                i  = up.i + left.i - cross.i;
                j  = up.j + left.j - cross.j;
                o  = up.o + left.o - cross.o;

                char now = map[ii][jj];
                if(now == 'J') j++;
                else if(now == 'O') o++;
                else if(now == 'I') i++;

                resultMap[ii][jj] = new Ground(j, o, i);

            }
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) -1;
            int c1 = Integer.parseInt(st.nextToken()) -1;
            int r2 = Integer.parseInt(st.nextToken()) -1;
            int c2 = Integer.parseInt(st.nextToken()) -1;
            Ground calculate = calculate(r1, c1, r2, c2);
            sb.append(calculate.j).append(" ").append(calculate.o)
                    .append(" ").append(calculate.i).append("\n");
        }

        System.out.print(sb);
    }
    static Ground calculate(int r1, int c1, int r2, int c2){



        // 오른쪽 아래
        Ground rightDown = resultMap[r2][c2];

        int i = rightDown.i;
        int j = rightDown.j;
        int o = rightDown.o;

        if(c1-1 >=0){
            // 왼쪽 아래
            Ground leftDown = resultMap[r2][c1-1];
            i -= leftDown.i;
            o -= leftDown.o;
            j -= leftDown.j;
        }
        if(r1-1>=0){
            // 오른쪽 위
            Ground rightUp = resultMap[r1-1][c2];
            i -= rightUp.i;
            o -= rightUp.o;
            j -= rightUp.j;
        }

        if(r1-1 >=0 && c1 -1>=0){
            // 왼쪽 위
            Ground leftUp = resultMap[r1-1][c1-1];
            i += leftUp.i;
            o += leftUp.o;
            j += leftUp.j;
        }

//        i = rightDown.i - leftDown.i - rightUp.i + leftUp.i;
//        j = rightDown.j - leftDown.j - rightUp.j + leftUp.j;
//        o = rightDown.o - leftDown.o - rightUp.o + leftUp.o;

        return new Ground(j, o ,i);
    }
    static class Ground{
        int j; // 정글
        int o; // 바다
        int i; // 얼음

        public Ground(int j, int o, int i){
            this.j = j;
            this.o = o;
            this.i = i;
        }

        public String toString(){
            return "j: " + j + " i: " + i +" o: "+o;
        }
    }
}