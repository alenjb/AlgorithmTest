import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static List<Fireball>[][] arr;
    static Set<List<Integer>> visited;
    static Queue<Fireball> q;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            q.add(new Fireball(r, c, mass, speed, direction));
        }
        for(int i=0; i<K; i++) {
            arr = new List[N][N];
            visited = new HashSet<>();
            for(int a=0;a<N; a++){
                for(int b=0; b<N; b++){
                    arr[a][b] = new ArrayList<>();
                }
            }
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Fireball poll = q.poll();
                move(poll); //움직이기
            }
            q.clear();
            for(List<Integer> pos : visited){
                int pR = pos.get(0);
                int pC = pos.get(1);
                if (arr[pR][pC].size() > 1) { //한칸에 여러개가 있으면
                    update(pR, pC);
                } else q.add(arr[pR][pC].get(0));
            }
        }

        long result = 0;
        for (Fireball fireball : q) {
            result += fireball.mass;
        }
        System.out.println(result);

    }

    static void move(Fireball fireball){
        int direction = fireball.direction;
        int speed = fireball.speed;
        int newR = fireball.r;
        int newC = fireball.c;
        // 열
        if(0 < direction && direction < 4) newC+=speed;
        else if(4 < direction && direction < 8) newC+=-speed;

        //행
        if(3 <= direction && direction <= 5) newR+=speed;
        else if(direction == 0 || direction == 1 || direction == 7) newR+=-speed;

        newR %= N;
        newC %= N;
        if(newR <0) newR += N;
        if(newC <0) newC += N;
        arr[newR][newC].add(new Fireball(newR, newC, fireball.mass, fireball.speed, fireball.direction));
        visited.add(new ArrayList<>(Arrays.asList(newR, newC)));
    }

    // 두개 이상이 한칸인 경우
    static void update(int r, int c){
        int odd = 0;
        int even = 0;

        int massSum = 0;
        int speedSum = 0;
        int size = arr[r][c].size();
        for (Fireball fireball : arr[r][c]) {
            massSum += fireball.mass;;
            speedSum += fireball.speed;
            if(fireball.direction % 2 == 0) even++;
            else odd++;
        }
        // 질량
        massSum /=5;
        if(massSum ==0) return;
        // 속력
        speedSum /= size;
        List<Integer> d = new ArrayList<>();
        //방향
        if(odd == size || even == size){
            d.add(0);
            d.add(2);
            d.add(4);
            d.add(6);
        }else {
            d.add(1);
            d.add(3);
            d.add(5);
            d.add(7);
        }

        // 분화
        for(int i=0; i<4; i++){
            q.add(new Fireball(r,c,massSum, speedSum, d.get(i)));
        }
    }

    static class Fireball{
        int r;
        int c;
        int mass; //질량
        int speed; // 속력
        int direction; //방향

        public Fireball(int r, int c, int mass, int speed, int direction) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
}