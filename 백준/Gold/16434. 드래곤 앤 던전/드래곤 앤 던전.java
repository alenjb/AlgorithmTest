import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Room[] rooms;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());
        rooms = new Room[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isMonster = Integer.parseInt(st.nextToken()) == 1;
            int roomAtk = Integer.parseInt(st.nextToken());
            int roomLife = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(isMonster, roomAtk, roomLife);
        }

        System.out.println(bs(atk));
    }
    
    static boolean check(long max, long atk) {
        long hp = max;

        for (Room room : rooms) {
            if (room.isMonster) { // 몬스터인 경우
                if (room.life % atk == 0) hp -= (room.life / atk - 1) * room.atk;
                else hp -= (room.life / atk) * room.atk;
                if (hp <= 0) return false;
            } else { // 포션인 경우
                hp += room.life;
                atk += room.atk;
                if (hp > max) hp = max;
            }
        }
        return true;
    }
    
    static long bs(long atk) {
        long left = 0;
        long right = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (check(mid, atk)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    static class Room {
        boolean isMonster;
        int atk;
        int life;

        Room(boolean isMonster, int atk, int life) {
            this.isMonster = isMonster;
            this.atk = atk;
            this.life = life;
        }
    }
}