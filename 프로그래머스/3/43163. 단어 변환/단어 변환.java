import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node poll = q.poll();
            String now = poll.word;
            int count = poll.cnt;

            if (now.equals(target)) return count;

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(now, words[i])) {
                    visited[i] = true;
                    q.add(new Node(words[i], count + 1));
                }
            }
        }
        return 0;
    }

    static boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    static class Node {
        String word;
        int cnt;

        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
