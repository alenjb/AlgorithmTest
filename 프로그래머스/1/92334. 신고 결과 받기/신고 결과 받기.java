import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 당한 맵(신고 당한 사람, 몇번 당했는지)
        Map<String, Integer> numberMap = new HashMap<>();
        
        // 누가 신고했는지 (신고 당한 사람, 신고자 리스트)
        Map<String, List<String>> map = new HashMap<>();
        
        // 메일 맵 (메일 받을 사람, 메일 횟수)
        Map<String, Integer> mailMap = new HashMap<>();

        Set<String> blackList = new HashSet<>();
        
        for(int i=0; i<report.length; i++){
            String [] r = report[i].split(" ");
            // 신고자
            String tell = r[0];
            // 신고 당한 사람
            String told = r[1];
            
            
            if(map.containsKey(told)){
                if(map.get(told).contains(tell)) continue;
                map.get(told).add(tell);
            }else {
                List<String> list = new ArrayList<>();
                list.add(tell);
                map.put(told, list);
            }
            
            if(numberMap.containsKey(told)){
                int num = numberMap.get(told);
                numberMap.put(told, num + 1);
            }else {
                numberMap.put(told, 1);
            }
            if(numberMap.get(told) >= k) blackList.add(told);
        }
        
        for(String id : id_list) mailMap.put(id, 0);
        for(String told : blackList){
            List<String> list = map.get(told);
            for(String p : list){
                mailMap.put(p , mailMap.get(p)+1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            String id = id_list[i];
            answer[i] = mailMap.get(id);
        }
        return answer;
    }
}