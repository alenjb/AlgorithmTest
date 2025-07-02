import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int l = words.length;
        int wl = begin.length();

        String[] allWords = new String[l + 1];
        allWords[0] = begin;
        for (int i = 0; i < l; i++) allWords[i + 1] = words[i];
        l++;

        boolean[] visited = new boolean[l];
        Map<String, Integer> map = new HashMap<>();
        List<Integer>[] arr = new List[l];
        for (int i = 0; i < l; i++) {
            arr[i] = new ArrayList<>();
            map.put(allWords[i], i);
        }

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (getDiff(allWords[i], allWords[j]) == 1) {
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }

        // target이 words에 없으면 변환 불가
        if (!map.containsKey(target)) return 0;

        // BFS
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0, 0)); // begin은 항상 0번

        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (visited[poll.num]) continue;
            visited[poll.num] = true;

            if (poll.s.equals(target)) return poll.cnt;

            for (int next : arr[poll.num]) {
                if (!visited[next]) {
                    q.offer(new Node(allWords[next], poll.cnt + 1, next));
                }
            }
        }

        return 0;
    }

    static int getDiff(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }

    static class Node {
        String s;
        int cnt;
        int num;

        public Node(String s, int cnt, int num) {
            this.s = s;
            this.cnt = cnt;
            this.num = num;
        }
    }
}
