import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char [][] arr = new char[5][9];
    static int [] initPerm = new int [12];
    static List<String> results = new ArrayList<>();
    static boolean hasResult = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> available = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12));

        // 입력 받고, initPerm 완성
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                char now = line.charAt(j);
                arr[i][j] = now;
                if (now != '.') {
                    int num = now - 'A' + 1;
                    if (available.contains(num)) {
                        available.remove(Integer.valueOf(num));
                    }
                    if (i == 0) initPerm[0] = num;
                    else if (i == 1) {
                        initPerm[(j + 1) / 2] = num;
                    } else if (i == 2) {
                        if (j == 2) initPerm[5] = num;
                        else initPerm[6] = num;
                    } else if (i == 3) {
                        initPerm[(j + 13) / 2] = num;
                    } else initPerm[11] = num;
                }
            }
        }

        // 가능한 순열을 생성하면서 즉시 검사
        perm(initPerm, 0, available);
//        Collections.sort(results);
//        printResult(results.get(0));
    }

    static void perm(int[] nowPerm, int idx, List<Integer> available) {
        if (idx == 12) {
            if (check(nowPerm)) {
                StringBuilder sb = new StringBuilder();
                for (int n : nowPerm) {
                    sb.append((char) (n + 'A' - 1)).append(" ");
                }
                printResult(sb.toString());
                hasResult = true;
            }
            return;
        }

        // 현재 자리에 이미 채워져 있는 경우
        if (nowPerm[idx] != 56 && nowPerm[idx] != 0) {
            perm(nowPerm, idx + 1, available);
        } else {
            for (int i = 0; i < available.size(); i++) {
                int now = available.get(i);
                nowPerm[idx] = now;

                List<Integer> newAvailable = new ArrayList<>(available);
                newAvailable.remove(Integer.valueOf(now));

                perm(nowPerm, idx + 1, newAvailable);
                if(hasResult) return;
            }
            nowPerm[idx] = 0;  // 배열 복구
        }
    }

    // 각 줄이 26인지 계산하는 메서드
    static boolean check(int[] nowPerm) {
        int[] sum = new int[6];
        sum[0] = nowPerm[0] + nowPerm[2] + nowPerm[5] + nowPerm[7];
        sum[1] = nowPerm[0] + nowPerm[3] + nowPerm[6] + nowPerm[10];
        sum[2] = nowPerm[7] + nowPerm[8] + nowPerm[9] + nowPerm[10];
        sum[3] = nowPerm[1] + nowPerm[2] + nowPerm[3] + nowPerm[4];
        sum[4] = nowPerm[1] + nowPerm[5] + nowPerm[8] + nowPerm[11];
        sum[5] = nowPerm[4] + nowPerm[6] + nowPerm[9] + nowPerm[11];

        for (int num : sum) {
            if (num != 26) return false;
        }
        return true;
    }

    static void printResult(String result) {
        StringTokenizer st = new StringTokenizer(result);
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> pos = new ArrayList<>();
        pos.add(Arrays.asList(0, 4));
        pos.add(Arrays.asList(1, 1));
        pos.add(Arrays.asList(1, 3));
        pos.add(Arrays.asList(1, 5));
        pos.add(Arrays.asList(1, 7));
        pos.add(Arrays.asList(2, 2));
        pos.add(Arrays.asList(2, 6));
        pos.add(Arrays.asList(3, 1));
        pos.add(Arrays.asList(3, 3));
        pos.add(Arrays.asList(3, 5));
        pos.add(Arrays.asList(3, 7));
        pos.add(Arrays.asList(4, 4));

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (pos.contains(Arrays.asList(i, j))) {
                    sb.append(st.nextToken());
                } else sb.append(".");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}