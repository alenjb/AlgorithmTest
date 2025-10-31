import java.util.*; 
class Solution {
    static int [] parent;
    public int solution(int n, int[][] wires) {
        parent = new int [n+1];
        for(int i=1; i<=n; i++) parent[i] = i;
        
        for(int i=0; i<wires.length; i++){
            union(wires[i][0], wires[i][1]);
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
    // 1️⃣ parent 새로 초기화
    for (int j = 1; j <= n; j++) parent[j] = j;
    
    // 2️⃣ i번째 간선 제외하고 연결
    for (int j = 0; j < wires.length; j++) {
        if (i == j) continue;
        union(wires[j][0], wires[j][1]);
    }

    // 3️⃣ 그룹별 노드 개수 계산
    int[] cnt = new int[n+1];
    for (int j = 1; j <= n; j++) {
        cnt[find(j)]++;
    }

    int max = 0, min = 101;
    for (int j = 1; j <= n; j++) {
        if (cnt[j] > 0) {
            max = Math.max(max, cnt[j]);
            min = Math.min(min, cnt[j]);
        }
    }

    answer = Math.min(answer, max - min);
}

        return answer;
    }
    
    static void union(int a, int b){
        int aa = find(a);
        int bb = find(b);
        parent[aa] = bb;
    }
    
    static int find(int num){
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
}