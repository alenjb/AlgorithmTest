import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            String g = genres[i];
            if(map.get(g) == null) map.put(g, plays[i]);
            else {
                int tmp = map.get(g);
                tmp += plays[i];
                map.put(g, tmp);
            }
        }
        
        //장르 pq 만들기
        PriorityQueue<Genre> mpq = new PriorityQueue<>();

        for(String g: map.keySet()){
            mpq.add (new Genre(g, map.get(g)));
        }
        
        //장르 pq에서 꺼내서 각 pq들 만들기
        while(!mpq.isEmpty()){
            String genre = mpq.poll().genre;
            PriorityQueue<Song> pq = new PriorityQueue<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    Song s = new Song(i, plays[i]);
                    pq.add(s);
                }
            }
            int cnt = 0;
            while(!pq.isEmpty() && cnt<2){
                list.add(pq.poll().num);
                cnt++;
            }
        }
        
        int [] answer = new int[list.size()];
        int idx = 0;

        for(int ii : list){
            answer[idx++] = ii;    
        }
        return answer;
    }
    
}
    class Genre implements Comparable<Genre>{
        String genre;
        int num;
        
        Genre(String genre, int num){
            this.num = num;
            this.genre = genre;
        }
        
        @Override
        public int compareTo(Genre g){
            return g.num - this.num;
        }
    }

    
    class Song implements Comparable<Song>{
        int num;
        int play;
        
        Song(int n, int p){
            this.num = n;
            this.play = p;
        }
        
        @Override
        public int compareTo(Song s){
            if(this.play!= s.play) return s.play - this.play;
            else return this.num - s.num;
        }
    }
