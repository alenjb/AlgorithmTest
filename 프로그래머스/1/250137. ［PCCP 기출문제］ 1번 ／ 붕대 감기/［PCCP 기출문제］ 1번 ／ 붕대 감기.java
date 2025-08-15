import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int atkl = attacks.length;
        int max = health;
        int last = attacks[atkl-1][0];
        int idx = 0; // 공격 인덱스
        int l = 0; // 연속 길이
        for(int time=0; time<=last; time++){
            boolean attacked = false;
            // 공격 여부 확인
            if(attacks[idx][0] == time){// 공격
                health -= attacks[idx++][1];
                attacked = true;
            }
            if(health <=0) return -1;
            
            // 연속 여부
            if(attacked) l =0;
            else{
                // 체력 회복
                int tmp = health + bandage[1];
                health = Math.min(tmp, max);
                l++;
                if(l == bandage[0]) {
                    health = Math.min(max, health + bandage[2]);
                    l = 0;
                }
            }
            
            
        }
        return health;
    }
}