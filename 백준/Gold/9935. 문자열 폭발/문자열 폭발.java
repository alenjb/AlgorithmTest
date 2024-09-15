import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer>[] alpha = new List['z' - 'A' + 1];
    static List<Integer>[] number = new List[10];
    static String bombLine, line;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        bombLine = br.readLine(); // 폭발 문자열

        while (true) {
            for (int i = 0; i < alpha.length; i++) alpha[i] = new ArrayList<>();
            for (int i = 0; i < number.length; i++) number[i] = new ArrayList<>();

            // 각 알파벳의 출현 위치 기록
            for (int i = 0; i < line.length(); i++) {
                char now = line.charAt(i);
                if (now >= '0' && now <= '9') number[now - '0'].add(i);
                else alpha[now - 'A'].add(i);
            }

            // 폭발 결과 가져오기
            String newLine;
            newLine = makeResult();

            if (newLine.length() == 0) {
                System.out.println("FRULA");
                return;
            }
            if (newLine.equals(line)) break;

            line = newLine;
        }
        System.out.println(line);
    }

    static String makeResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            sb.append(line.charAt(i));

            // 폭발 문자열의 길이만큼 검사
            if (sb.length() >= bombLine.length()) {
                boolean isMatch = true;

                // 폭발 문자열 매칭 여부 확인
                for (int j = 0; j < bombLine.length(); j++) {
                    if (sb.charAt(sb.length() - bombLine.length() + j) != bombLine.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                // 폭발 문자열이 매칭되면 해당 부분 제거
                if (isMatch) {
                    sb.delete(sb.length() - bombLine.length(), sb.length());
                }
            }
        }
        return sb.toString();
    }
}