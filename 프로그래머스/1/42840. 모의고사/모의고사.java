import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int first = 0;
        int second = 0;
        int third = 0;
        
        int [] fA = new int []{1,2,3,4,5};
        int [] sA = new int []{2, 1, 2, 3, 2, 4, 2, 5};
        int [] tA = new int []{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        
        for(int i=0; i<answers.length; i++){
            int ans = answers[i];
            //1번 확인
            if(fA[i % 5] == ans) first++;
            //2번 확인
            if(sA[i % 8] == ans) second++;
            //3번 확인
            if(tA[i % 10] == ans) third++;
        }
        
        int max = 0;
        max = Math.max(Math.max(first, second), third);
        List<Integer> list = new ArrayList<>();
        if(first == max) list.add(1);
        if(second == max) list.add(2);
        if(third == max) list.add(3);
        
        int[] answer = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        //1번 5주기
        // 12345
        //2번 8주기
        // 2, 1, 2, 3, 2, 4, 2, 5
        //3번 10주기
        // 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        return answer;
    }
}