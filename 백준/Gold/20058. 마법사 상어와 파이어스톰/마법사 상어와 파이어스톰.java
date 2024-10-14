import javax.management.MXBean;
import java.beans.Visibility;
import java.util.*;

public class Main {
    static int N, Q, L;
    static int [][] arr;
    static int [][] arr2;
    static int [] rotate;
    static int [] dr = {0, -1, 1, 0};
    static int [] dc = {-1, 0, 0, 1};
    static boolean[][] visited;
    static List<Integer> list;
    static List<int[]> minuses;

    static int maxVal = -1;
    static long total = 0;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 격자의 크기를 결정 2^n
        Q = sc.nextInt(); // 파이어스톰 시행 횟수
        L = (int)Math.pow(2, N); // 총 길이
        arr = new int[L][L];
        arr2 = new int[L][L];
        rotate = new int[Q];

        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                arr[i][j] = sc.nextInt();
            }
        }



        for(int i=0; i<Q; i++) {
            int nowTurn = sc.nextInt();
            maxVal = 0;
            total = 0;
            visited = new boolean[L][L];
            turn(nowTurn);
        }

        System.out.println(total);
        System.out.println(maxVal);
//        System.out.println("total = " + total);
//        System.out.println("maxVal = " + maxVal);

//        for(int i=0; i<L; i++){
//            for(int j=0; j<L; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }

    }

    private static void turn(int nowTurn) {
        int tmpL = (int) Math.pow(2, nowTurn);
        list = new ArrayList<>();
        cnt = 0;
        for(int i=0; i<=L-tmpL; i+=tmpL){
            for(int j=0; j<=L-tmpL; j+=tmpL){
                save(tmpL, i, j);
            }
        }

        for(int i=0; i<L; i+=tmpL){
            for(int j=tmpL-1; j<L; j+=tmpL){
                print(tmpL, list, i, j);
            }
        }

        copyArr();
        minus();
        BFS();
        totalSum();
    }
    private static void save(int limit, int r, int c) {
        for(int i=r; i<r+limit; i++){
            for(int j=c; j<c+limit; j++){
                list.add(arr[i][j]);
            }
        }
    }
    private static void print(int limit, List<Integer> list, int r, int c) {
        for(int j=c; j>c-limit; j--){
            for(int i=r; i<r+limit; i++){
                arr2[i][j] = list.get(cnt++);
            }
        }
    }
    private static void BFS(){
        Queue<int []> q = new ArrayDeque<>();
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                int tmpCnt = 0;
                if(!visited[i][j] && arr[i][j]>0) q.add(new int[]{i, j});
                while (!q.isEmpty()){
                    int[] poll = q.poll();
                    int rr = poll[0];
                    int cc = poll[1];
                    visited[rr][cc] = true;
                    tmpCnt++;

                    for(int p=0; p<4; p++){
                        int newRR = rr + dr[p];
                        int newCC = cc + dc[p];
                        if(newRR>=0 && newRR<L && newCC>=0 && newCC<L && arr[newRR][newCC]>0 && !visited[newRR][newCC]) {
                            visited[newRR][newCC] = true;
                            q.add(new int[]{newRR, newCC});
//                            tmpCnt++;
                        }
                    }
                }
                maxVal = Math.max(tmpCnt, maxVal);
            }
        }
    }

    private static void minus(){
        minuses = new ArrayList<>();
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int newR = i + dr[k];
                    int newC = j + dc[k];
                    if(newR>=0 && newR<L && newC>=0 && newC<L && arr[newR][newC]>0) cnt++;
                }
                if(cnt<3 && arr[i][j] >0) {
                    minuses.add(new int[]{i,j});
                }
            }
        }
        for(int [] pos : minuses) arr[pos[0]][pos[1]]--;
        minuses.clear();

    }
    private static void copyArr(){
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                arr[i][j] = arr2[i][j];
            }
        }
    }

    private static void totalSum(){
        total = 0;
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                total+= arr[i][j];
            }
        }
    }
}