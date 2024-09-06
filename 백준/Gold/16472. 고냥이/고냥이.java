import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int [] arr, alpha;
    static int n;
    static String line;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        line = sc.next();
        arr = new int[line.length()];
        alpha = new int ['z'-'a'+1]; //각 알파벳의 마지막 출현 위치

        Arrays.fill(alpha,-1);

        // 찾기
        Set<Character> set = new HashSet<>();
        int result = 1;
        int nowKind = 1; // 첫번째꺼를 넣으므로
        int nowLen = 1; // 첫번째꺼를 넣으므로

        // 첫번째 꺼 넣어놓기
        set.add(line.charAt(0));
        alpha[line.charAt(0)-'a'] = 0;
        for(int i=1; i<arr.length; i++){
            char next = line.charAt(i);
            //최종 출현 위치 업데이트
            if(!set.contains(next) && nowKind == n){ // 포함되어 있지 않은데 최대 개수를 넘으면
                result = Math.max(nowLen, result);
                char minAlpha = findMin();
                nowLen = i - alpha[minAlpha - 'a']; //현재 길이 업데이트
                alpha[minAlpha-'a'] = -1;
                set.remove(minAlpha);

                set.add(next);
            }else{
                if(!set.contains(next)) nowKind++;
                set.add(next);
                nowLen++;
                result = Math.max(nowLen, result);
            }
            alpha[next-'a'] = i; //최종 출현 위치 업데이트
        }
        System.out.println(result);
    }

    private static char findMin() {
        int min = Integer.MAX_VALUE;
        char c = 'a'; //임시 값
        for(int i=0 ;i<alpha.length; i++){
            if(alpha[i]!=-1 && alpha[i] < min){
                min = alpha[i];
                c = (char)('a'+i);
            }
        }
        return c;
    }
}