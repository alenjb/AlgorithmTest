import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static boolean [] visited;
    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        visited = new boolean[len];
        for(int i=0; i<len; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                DFS(tickets[i][0], tickets[i][1], "ICN", tickets, tickets.length-1);             
                visited[i] = false;
            }
        }
        Collections.sort(list);
        String [] ss = list.get(0).split(" ");
        return ss;
    }
    
    static void DFS(String start, String end, String now, String[][] tickets, int remain){
        if(remain ==0) {
            list.add(now+" "+end); 
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(end)){
                visited[i] = true;
                DFS(tickets[i][0], tickets[i][1], now + " " +tickets[i][0], tickets, remain-1);
                visited[i] = false;
            }
        }
    }
}