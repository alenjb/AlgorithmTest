import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();    
    static Map<String, Integer> count = new HashMap<>();    
    public int[] solution(String[] genres, int[] plays) {
        Song[] answer = new Song[genres.length];
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            int id = i;
            map.put(genre, map.getOrDefault(genre, 0) + play);
            count.put(genre, map.getOrDefault(genre, 0) + 1);
            answer[i] = new Song(genre, play, id);
        }
        Arrays.sort(answer);
        // 장르가 2개 미만이면 제거
        for(String key : count.keySet()){
            if(count.get(key) <2) count.remove(key);
            else map.put(key, 0);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<answer.length; i++){
            Song now = answer[i];
            if(map.getOrDefault(now.genre, 2) <2){
                list.add(answer[i].id);
                map.put(now.genre, map.get(now.genre)+1);
            }
        }
        int [] result = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    static class Song implements Comparable<Song>{
        String genre;
        int plays;
        int id;

        public Song(String g, int p, int i){
            this.genre = g;
            this.plays = p;
            this.id = i;
        }

        @Override
        public int compareTo(Song s){
            // 장르
            int nowG = map.get(this.genre);
            int compG = map.get(s.genre);
            if(nowG > compG) return -1;
            else if(nowG < compG) return 1;

            // 재생 횟수
            if(this.plays > s.plays) return -1;
            else if(this.plays < s.plays) return 1;

            // 고유번호
            if(this.id < s.id) return -1;
            else return 1;
        }
    }
}

