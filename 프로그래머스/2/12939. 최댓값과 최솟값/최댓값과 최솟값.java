import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자열을 공백 기준으로 분리하여 문자열 배열 생성
        String[] tokens = s.split(" ");
        // tokens 배열의 길이를 이용하여 정수 배열 생성
        int[] arr = new int[tokens.length];
        
        // 각 토큰을 정수로 변환하여 arr 배열에 저장
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<tokens.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        
        return min + " " + max;
    }
}
