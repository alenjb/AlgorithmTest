import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[] heights = new int[c];

        // 각 열에서 가장 위에 있는 인형의 위치 찾기
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if (board[j][i] != 0) {
                    heights[i] = j;
                    break;
                }
            }
        }

        // moves를 순회하면서 인형 뽑기 진행
        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;

            if (heights[col] >= r) continue; // 유효한 범위인지 검사

            int now = board[heights[col]][col];  
            if (now == 0) continue; // 빈 공간이면 넘어감

            if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(now);
            }

            heights[col]++; // 인형을 뽑았으므로 다음 위치로 업데이트
        }

        return answer;
    }
}
