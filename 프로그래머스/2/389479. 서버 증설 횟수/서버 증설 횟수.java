import java.util.*;
class Solution {
    static int [] available; // 현재 가용 서버 수
    static int l;
    static int answer = 0;
    public int solution(int[] players, int m, int k) {
        l = players.length;
        available = new int [l];
        
        for(int i=0; i<l; i++){
            int nowPlayers = players[i];
            int nowServers = available[i];
            int need = nowPlayers/m;
            
            // 서버가 충분
            if(nowServers >= need) continue;
            else{// 서버 증설
                int times = need - nowServers;
                for(int j=0; j<times; j++){
                    makeServer(i, k);
                    answer++;
                }
            }
            
        }
        return answer;
    }
    
    // 서버를 증설
    public void makeServer(int nowTime, int k){
        for(int i=nowTime; i< nowTime + k; i++){
            if(i >= l) break;
            available[i]++;
        }
    }
}