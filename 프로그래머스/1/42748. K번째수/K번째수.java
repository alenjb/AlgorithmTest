import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        int idx = 0;
        for(int [] arr : commands){
            int pr = arr[2]-1;
            int aIdx = arr[0]-1;
            int bIdx = arr[1]-1;
            List<Integer> list = new ArrayList<>();
            for(int i=aIdx; i<=bIdx; i++) list.add(array[i]);
            Collections.sort(list);
            answer[idx++] = list.get(pr);
        }
        return answer;
    }
}