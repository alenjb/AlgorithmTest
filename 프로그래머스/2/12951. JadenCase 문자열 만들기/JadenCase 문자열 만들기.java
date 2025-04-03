import java.util.*;

class Solution {
    public String solution(String s) {
        String[] ss = s.split(" ", -1); // 공백 유지
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ss.length; i++) {
            String word = ss[i];
            if (word.length() == 0) {
                sb.append("");
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1).toLowerCase());
            }
            if (i < ss.length - 1) sb.append(" ");
        }

        return sb.toString();
    }
}
