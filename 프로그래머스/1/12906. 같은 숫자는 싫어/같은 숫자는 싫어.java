import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for(int i=1; i<arr.length; i++){
            int top = stack.peek();
            if(top != arr[i]){ //다르면 넣기
                stack.push(arr[i]);
            }
        }
        int size = stack.size();
        int [] answer = new int [size];
        int n = size-1;
        for(int i=0; i<size; i++){      
            answer[n-i] = stack.pop();
        }
        return answer;
    }
}