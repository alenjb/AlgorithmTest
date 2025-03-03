import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static List<Integer> [] arr;
    static int [] result;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // HashMap<Integer, String> map2 = new HashMap<>();
        int n = enroll.length;
        arr = new ArrayList[n];
        for(int i=0; i<n; i++) arr[i] = new ArrayList<>();
        result = new int [n];
        
        //맵 만들기
        for(int i=0; i<n; i++) map.put(enroll[i], i);
        // for(int i=0; i<n; i++) map2.put(i, enroll[i]);
        
        // 연결 리스트 구성(refferal 돌면서)
        for(int i=0; i<n; i++){
            
            int invited = map.get(enroll[i]); // 초대받은 사람 번호
            if(referral[invited].equals("-")) continue; //초대한 사람이 없으면 넘어가기
            int invite = map.get(referral[invited]); // 초대한 사람 번호
            arr[invited].add(invite); //연결
        }
        
        // 셀러들 돌면서 amout 계산
        int sn = seller.length;
        
        for(int i=0; i<sn; i++){
            // 판매한 사람 번호
            int sellNum = map.get(seller[i]);
            // 판매액
            int sellAmount = 100 * amount[i];
            
            cal(sellNum, sellAmount, enroll, referral, seller, amount);         
        }
        
        return result;
    }
    void cal(int sellNum, int nowAmount, String[] enroll, String[] referral, String[] seller, int[] amount){
        if(nowAmount == 0) return;
            

                // 초대한 사람이 먹을 이익금
        int inviteAmount = nowAmount / 10;
        result[sellNum] += (nowAmount - inviteAmount);
        
        if(referral[sellNum].equals("-") || inviteAmount == 0){ // 판매한 사람이 최상단이면
            return;                
        }

        // 초대한 사람이 있는 경우        
        
        // 초대한 사람 번호
        int inviteNum = map.get(referral[sellNum]);

        cal(inviteNum, inviteAmount, enroll, referral, seller, amount);

    }
    
}