import java.util.*;

class Solution {
    static int [] arr;
    static int [] answer;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int length = enroll.length;
        Map<String, Integer> map = new HashMap<>();
        arr = new int [length];
        answer = new int [length]; //돈 배열        
        map.put("센터", 0);
        for(int i=0; i<length; i++){
            String name = enroll[i];
            map.put(name, i);
        }
        
        for(int i=0; i<length; i++){
            String from = referral[i];
            String to = enroll[i];
            if (from.equals("-")) {
                arr[map.get(to)] = -1;  // 부모 없음 표시
            } else {
                arr[map.get(to)] = map.get(from);
            }
        }
        
        
        int sl = seller.length;
        for(int i=0; i<sl; i++){
            String nowSeller = seller[i];
            
            int nowSellerIdx = map.get(nowSeller);
            int money = amount[i] * 100;
            int to = arr[nowSellerIdx];
            
            while(to != -1){
                int giveMoney = money / 10;
                int tmpMoney = money - giveMoney;
                // break;
                if(giveMoney < 1){ // 줄 돈이 1원 미만
                    answer[nowSellerIdx] += money;
                    break;
                }else{ //10프로 뺏김
                    answer[nowSellerIdx] += tmpMoney;
                    money = giveMoney;
                    nowSellerIdx = to;
                    to = arr[nowSellerIdx];
                }
            }
            if(to ==-1){
                //arr[to] == "-" 인 상태
                int giveMoney = money / 10;
                int tmpMoney = money - giveMoney;
                answer[nowSellerIdx] += tmpMoney;                
            }
        }
        return answer;
    }
}