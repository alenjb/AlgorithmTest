import java.util.*;
import java.io.*;

public class Main {
    static int N,l,M;
    static int result = 0;
    static ArrayList<Pos> fishes = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1,1 부터 시작
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            fishes.add(new Pos(y,x));
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                catchFish(i,j);
            }
        }

        System.out.println(result);
    }

    static void catchFish(int fish1, int fish2){
        int r = fishes.get(fish1).r; // y 좌표 기준 물고기
        int c = fishes.get(fish2).c; // x좌표 기준 물고기

        int width = 1;
        int height = ( l - 2 * width ) / 2;

        while(height>0){
            // 잡을 수 있는 물고기 수
            int cnt = 0;

            for(int i=0;i<M;i++){
                if(
                    // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 x 길이 내에 물고기가 존재하는지 확인
                        c <= fishes.get(i).c &&
                                fishes.get(i).c <= c + height &&
                                // 두 물고기 중 한 물고기를 기준으로 그물 길이만큼의 y 길이 내에 물고기가 존재하는지 확인
                                r <= fishes.get(i).r &&
                                fishes.get(i).r <= r + width
                )
                    cnt++;
            }

            // 현재 물고기 수와 답과의 최대값 구하기
            if(result < cnt) result = cnt;

            // 다른 사이즈의 그물로 변환
            width++;
            height = (l - 2*width)/2;
        }
    }

}

class Pos {
    int r;
    int c;

    public Pos(int r, int c) {
        this.r = r;
        this.c = c;
    }
}