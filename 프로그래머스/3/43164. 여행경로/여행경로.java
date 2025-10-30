import java.util.*;
class Solution {
    static public List<String> list = new ArrayList<>();
    static public boolean [] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean [tickets.length];
        DFS(tickets, "ICN", "ICN", 0);
        Collections.sort(list);
        String [] answer = list.get(0).split(" ");
        return answer;
    }
    static void DFS(String [][] tickets, String from, String road, int used){
        int l = tickets.length;
        if(used == l){
            list.add(road);
            return;
        }
        
        
        for(int i=0; i<l; i++){
            if(!visited[i] && tickets[i][0].equals(from)){
                visited[i] = true;
                DFS(tickets, tickets[i][1], road + " "+ tickets[i][1], used+1);
                visited[i] = false;
            }
        }
    }
}