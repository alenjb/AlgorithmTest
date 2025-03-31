class Solution {
    public int[] solution(long n) {
        String sn = String.valueOf(n);
        int length = sn.length();
        int[] answer = new int[length];
        for(int i=0; i<length; i++){
            answer[i] = (int)(sn.charAt(length - 1 - i) -'0');
        }
        
        return answer;
    }
}