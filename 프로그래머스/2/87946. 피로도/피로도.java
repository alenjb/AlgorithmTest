import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        // k 현재 피로도
        int l = dungeons.length;
        perm(l, new boolean[l], "", 0);
        for(String s : list) gogo(s, dungeons, k);
        return answer;
    }
    
    static void perm(int l, boolean [] visited, String word, int nowL){
        if(nowL == l){
            list.add(new String(word));
            return;
        }
        for(int i=0; i<l; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(l, visited, word + i + "", nowL+1);
                visited[i] = false;
            }
        }
    }
    
    static public void gogo(String word, int[][] dungeons, int k){
        int p = k;
        int cnt = 0;
        for(int i=0; i<word.length(); i++){
            int now = Integer.parseInt(word.charAt(i)+"");
            int prepare = dungeons[now][0];
            int use = dungeons[now][1];
            if(p >= prepare){
                p-=use;
                cnt++;
            }else{
                answer = Math.max(cnt, answer);
                return;
            }
        }
        answer = Math.max(cnt, answer);
    }
}