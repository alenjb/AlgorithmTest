import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        HashMap<String, Integer> friends = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            String friend = name[i];      
            int score = yearning[i];  
            
            friends.put(friend, score);
        }
        
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(int j = 0; j < photo[i].length; j++){
                String friend = photo[i][j];
                if(friends.get(friend) != null){
                   score += friends.get(friend);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}