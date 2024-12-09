import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        // 슬라이딩 윈도우
        int answer = 0;
        int length = want.length;
        // 초기값        
        for(int i=0; i<10; i++){
            if(map.containsKey(discount[i])){
                int n = map.get(discount[i]);
                map.put(discount[i], n+1);
            }else{
                map.put(discount[i], 1);                
            }
        }
        if(check(want, number, length)) answer++;
        
        for(int i=10; i<discount.length; i++){
            // 빼기
            int minus = i - 10;
            int mNum = 0;
            if(map.containsKey(discount[minus])){
                mNum = map.get(discount[minus]);                
                map.put(discount[minus], mNum-1);
            }
            // 더하기
            int plus = i;
            int pNum = 0;
            if(map.containsKey(discount[plus])){
                pNum = map.get(discount[plus]);                
            }
            map.put(discount[plus], pNum+1);
            
            if(check(want, number, length)) answer++;
        }
        return answer;
    }
    
    // 만족하는지 확인
    static boolean check(String[] want, int[] number, int length){
        for(int i=0; i<length; i++){
            String name = want[i];
            if(!map.containsKey(name)) return false;
            else if(map.get(name) < number[i]) return false;
        }
        return true;
    }
}