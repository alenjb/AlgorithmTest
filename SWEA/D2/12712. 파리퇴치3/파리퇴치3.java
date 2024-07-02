import java.util.*;
import java.io.*;

class Solution {
    public static int [][] arr;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int test_case = 1; test_case <= T; test_case++) {
            // 1. 배열 저장
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxNum = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    // 2. 플러스 계산
                    int P = plus(n, m-1, i, j);
                    // 3. 대각선 계산
                    int C = cross(n, m-1, i, j);
                    int maxCase = Math.max(P, C);
                    if(maxCase > maxNum) {maxNum = maxCase;
                    }
                }
            }

            // 4. 출력
            bw.write("#" + test_case + " " + maxNum + "\n");
        }
        bw.flush();
    }

    public static int plus(int n, int m, int i, int j) {
        int total = 0;
        // 가로 다 더하기
        for(int a = i - m; a <= i + m; a++) {
            if(check(n, a, j)) total += arr[a][j];
        }
        // 세로 다 더하기
        for(int a = j - m; a <= j + m; a++) {
            if(check(n, i, a)) total += arr[i][a];
        }

        // 중복 중앙값 빼기
        total -= arr[i][j];
        return total;
    }

    public static int cross(int n, int m, int i, int j) {
        int total = 0;
        // 왼쪽 위 대각선 다 더하기
        for(int a = -m; a <= m; a++) {
            if(check(n, i + a, j + a)) total += arr[i + a][j + a];
        }
        // 오른쪽 위 대각선 다 더하기
        for(int a = -m; a <= m; a++) {
            if(check(n, i + a, j - a)) total += arr[i + a][j - a];
        }

        // 중복 중앙값 빼기
        total -= arr[i][j];
        return total;
    }

    public static boolean check(int n, int i, int j) {
        if(i >= 0 && j >= 0 && i < n && j < n) return true;
        return false;
    }
}
