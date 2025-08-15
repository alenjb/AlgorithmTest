import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        int n = points.length;
        int x = routes.length;
        int answer = 0;

        // 포인트 번호 → 좌표 매핑 (1-indexed)
        Pos[] pointMap = new Pos[n + 1];
        for (int i = 0; i < n; i++) {
            pointMap[i + 1] = new Pos(points[i][0], points[i][1]);
        }

        // 각 로봇 경로 시간 단위 위치 기록
        List<List<Pos>> robotPaths = new ArrayList<>();
        int maxTime = 0;

        for (int i = 0; i < x; i++) {
            int[] route = routes[i];
            List<Pos> path = new ArrayList<>();
            for (int j = 0; j < route.length - 1; j++) {
                Pos start = pointMap[route[j]];
                Pos end = pointMap[route[j + 1]];
                List<Pos> segment = shortestPath(start, end);
                if (!path.isEmpty()) segment.remove(0); // 겹치는 시작점 제거
                path.addAll(segment);
            }
            robotPaths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        // 시간 단위 시뮬레이션
        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> posCount = new HashMap<>();
            for (List<Pos> path : robotPaths) {
                if (t < path.size()) { // 이동 중인 로봇만
                    Pos p = path.get(t);
                    String key = p.r + "," + p.c;
                    posCount.put(key, posCount.getOrDefault(key, 0) + 1);
                }
            }
            for (int cnt : posCount.values()) {
                if (cnt > 1) answer++;
            }
        }

        return answer;
    }

    // 최단 경로 계산, r 먼저 이동
    private List<Pos> shortestPath(Pos start, Pos end) {
        List<Pos> path = new ArrayList<>();
        int r = start.r, c = start.c;
        path.add(new Pos(r, c));
        while (r != end.r) {
            r += (end.r > r ? 1 : -1);
            path.add(new Pos(r, c));
        }
        while (c != end.c) {
            c += (end.c > c ? 1 : -1);
            path.add(new Pos(r, c));
        }
        return path;
    }

    static class Pos {
        int r, c;
        Pos(int r, int c) { this.r = r; this.c = c; }
    }
}
