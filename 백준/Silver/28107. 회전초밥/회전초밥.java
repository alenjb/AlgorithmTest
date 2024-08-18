import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer>[] sushi; // 초밥 배열
        int[] eat; // 먹은 초밥 수 배열
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 손님 수
        int M = sc.nextInt(); // 초밥 수

        // 손님별 먹은 초밥 수 배열 초기화
        eat = new int[N + 1];
        // 초밥 리스트 배열 초기화
        sushi = new LinkedList[200_001];
        for (int i = 1; i <= 200_000; i++) {
            sushi[i] = new LinkedList<>();
        }

        // 손님들의 선호 리스트 채우기
        for (int i = 1; i <= N; i++) {
            int dishes = sc.nextInt();
            for (int j = 0; j < dishes; j++) {
                int now = sc.nextInt();
                sushi[now].add(i);
            }
        }

        // 요리사가 초밥을 만드는 과정
        for (int i = 1; i <= M; i++) {
            int now = sc.nextInt(); // 요리사가 현재 만든 초밥
            if (sushi[now].size() > 0) { // 초밥을 먹을 사람이 있으면
                int eatPerson = sushi[now].remove(0);
                eat[eatPerson]++;
            }
        }

        // 손님별 먹은 초밥 수 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(eat[i] + " ");
        }
    }
}