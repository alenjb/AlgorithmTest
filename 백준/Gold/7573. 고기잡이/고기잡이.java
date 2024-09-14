import java.util.*;
import java.io.*;

public class Main {
    static int l,M;
    static int result = 0;
    static ArrayList<Pos> fishes = new ArrayList<>(); // 물고기 위치 저장

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            fishes.add(new Pos(r,c));
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                catchFish(i,j);
            }
        }

        System.out.println(result);
    }

    static void catchFish(int fish1, int fish2){
        // 최대한 많은 물고기를 잡기 위해서는 그물의 모서리나 변이 물고기들과 맞닿아 있는 것이 유리하므로
        int r = fishes.get(fish1).r; // y 좌표 기준 물고기
        int c = fishes.get(fish2).c; // x좌표 기준 물고기

        int width = 1;
        int height = ( l - 2 * width ) / 2;

        while(height>0){
            int cnt = 0;

            for(int i=0;i<M;i++){
                if(
                    // x좌표 검사
                        c <= fishes.get(i).c && fishes.get(i).c <= c + height &&
                                // y좌표 검사
                                r <= fishes.get(i).r && fishes.get(i).r <= r + width
                )
                    cnt++;
            }

            result = Math.max(result, cnt);

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