import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static ArrayList<Integer> smallM, tallM, smallW, tallW;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());  // 사람 수
        smallM = new ArrayList<>();
        tallM = new ArrayList<>();
        smallW = new ArrayList<>();
        tallW = new ArrayList<>();

        // 남성 선호도 입력 처리
        StringTokenizer mens = new StringTokenizer(br.readLine());
        // 여성 선호도 입력 처리
        StringTokenizer womens = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int man = Integer.parseInt(mens.nextToken());
            int woman = Integer.parseInt(womens.nextToken());

            if (man > 0) {
                tallM.add(man);  // 키 큰 사람 선호
            } else {
                smallM.add(-man);  // 키 작은 사람 선호
            }

            if (woman > 0) {
                tallW.add(woman);  // 키 큰 사람 선호
            } else {
                smallW.add(-woman);  // 키 작은 사람 선호
            }
        }

        Collections.sort(smallM);
        Collections.sort(smallW);
        Collections.sort(tallM);
        Collections.sort(tallW);

        // 키 작은 남자와 키 큰 여자 매칭
        calculate(smallM, tallW, true);
        // 키 큰 남자와 키 작은 여자 매칭
        calculate(tallM, smallW, false);

        System.out.println(result);
    }

    // 커플 매칭 함수
    static void calculate(ArrayList<Integer> men, ArrayList<Integer> women, boolean preferShortMen) {
        int i = 0, j = 0;

        while (i < men.size() && j < women.size()) {
            int man = men.get(i);
            int woman = women.get(j);

            if (preferShortMen) {
                // 작은 남자와 큰 여자가 매칭
                if (man <= woman) {
                    i++;
                } else {
                    result++;
                    i++;
                    j++;
                }
            } else {
                // 큰 남자와 작은 여자가 매칭
                if (man >= woman) {
                    j++;
                } else {
                    result++;
                    i++;
                    j++;
                }
            }
        }
    }
}