import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int [][] arr, order;
    static int [] dr = {-1, -1, 1, 1};
    static int [] dc = {-1, 1, 1, -1};

    static int N, M;
    static List<Pos> newClouds;
    static List<Pos> prevClouds = new ArrayList<>(); //이전에 구름이었던 것들

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행과 열의 길이
        M = Integer.parseInt(st.nextToken()); // 움직임 개수
        arr = new int[N][N];
        order = new int[M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        int d = order[0][0];
        int s = order[0][1];

        List<Pos> clouds = new ArrayList<>();
//          (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다
        clouds.add(new Pos(N-1, 0));
        clouds.add(new Pos(N-1, 1));
        clouds.add(new Pos(N-2, 0));
        clouds.add(new Pos(N-2, 1));

        moveClouds(clouds, d, s);
        copyWater(prevClouds);
        newClouds = generateClouds();// 구름 생성
        prevClouds.clear();

        for(int c=1; c<M; c++){
            d = order[c][0];
            s = order[c][1];

            moveClouds(newClouds, d, s);
            newClouds.clear();
            copyWater(prevClouds);
            newClouds = generateClouds();// 구름 생성
            prevClouds.clear();
        }

        long sum = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += arr[i][j];
            }
        }

        System.out.println(sum);

    }

    static List<Pos> generateClouds() {
        List<Pos> results = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(has(i, j)) continue;
                if(arr[i][j]>=2){
                    arr[i][j] -=2;
                    results.add(new Pos(i,j));
                }
            }
        }
        return results;
    }

    private static boolean has(int r, int c) {
        for(Pos p : prevClouds){
            if(p.r == r && p.c == c) {
//                System.out.println(r+ " "+ c+ " 탈락");
                return true;
            }
        }
        return false;
    }

    private static void moveClouds(List<Pos> clouds, int d, int s) {
        for(Pos p : clouds){
            int r = p.r;
            int c = p.c;

            s = s % N;
            switch (d){
                case 1:// 왼쪽
                    c-=s;
                    break;
                case 2:// 왼쪽 위
                    r-=s;
                    c-=s;
                    break;
                case 3:// 위쪽
                    r-=s;
                    break;
                case 4:// 오른쪽 위
                    r-=s;
                    c+=s;
                    break;
                case 5:// 오른쪽
                    c+=s;
                    break;
                case 6:// 오른쪽 아래
                    r+=s;
                    c+=s;
                    break;
                case 7:// 아래쪽
                    r+=s;
                    break;
                case 8:// 왼쪽 아래
                    r+=s;
                    c-=s;
                    break;
            }

//            System.out.println("r = " + r + " c = "+c);
            if(r<0) r = N + r;
            if(c<0) c = N + c;
            if(r>(N-1)) r = r - N;
            if(c>(N-1)) c = c - N;

//            System.out.println("after r = " + r + " c = "+c);


            arr[r][c]++; // 물의 양 증가
            prevClouds.add(new Pos(r,c));
        }
    }

    private static void copyWater(List<Pos> p) {
        for(Pos pp: p){
            int r = pp.r;
            int c = pp.c;
            // 물복사 버그
            int waterCnt = 0; // 대각선에 물이 존재하는 개수
            for(int dd=0; dd<4; dd++){
                int newR = r + dr[dd];
                int newC = c + dc[dd];

                if(newR >N-1 || newR <0 || newC > N-1 || newC <0) continue;
                if(arr[newR][newC] >0) waterCnt++;
            }
            arr[r][c] += waterCnt; // 물 복사
        }
    }

    static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
}