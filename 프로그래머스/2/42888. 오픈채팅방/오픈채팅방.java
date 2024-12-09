import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        int length = record.length;
        int inOut = 0;
        Map<String, String> map = new HashMap<>();
        
        for(int i=0; i<length; i++){
            String [] r = record[i].split(" ");
            String order = r[0];
            String uid = r[1];
            String newId = "";
            if(r.length > 2) newId = r[2];
            
            if(r[0].charAt(0) == 'E'){ // 들어가기
                map.put(uid, newId);
                inOut++;
            }else if(r[0].charAt(0) == 'L'){ // 떠나기
                inOut++;                
            }else{ // 닉네임 바꾸기
                map.put(uid, newId);
            }
        }
        
        String[] answer = new String[inOut++];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<length; i++){
            String [] r = record[i].split(" ");
            String uid = r[1];

            if(r[0].charAt(0) == 'E'){ // 들어가기
                sb.append(map.get(uid)).append("님이 들어왔습니다.");
                answer[idx++] = sb.toString();
                sb.setLength(0);
            }else if(r[0].charAt(0) == 'L'){ // 떠나기
                sb.append(map.get(uid)).append("님이 나갔습니다.");                
                answer[idx++] = sb.toString();
                sb.setLength(0);
            }           
        }
        return answer;
    }
}