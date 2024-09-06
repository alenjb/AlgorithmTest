import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int [] alpha;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();
        alpha = new int ['z'-'a'+1]; // 각 알파벳의 마지막 출현 위치 배열

        Arrays.fill(alpha,-1); // 마지막 출현 위치를 -1로 초기화

        // 찾기
        Set<Character> set = new HashSet<>(); // 현재 인식가능한 알파벳들을 넣어둔 집합
        int result = 1; // 정답
        int nowKind = 1; // 현재 인식하고 있는 문자열의 종류 (첫번째꺼를 넣으므로 초기값은 1)
        int nowLen = 1; // 현재 인식하고 있는 문자열의 길이 (첫번째꺼를 넣으므로 초기값은 1)

        // 첫번째 꺼 미리 넣어두기
        set.add(line.charAt(0));
        alpha[line.charAt(0)-'a'] = 0;
        
        for(int i=1; i<line.length(); i++){
            char next = line.charAt(i);
            //최종 출현 위치 업데이트
            if(!set.contains(next) && nowKind == n){ // 포함되어 있지 않은데 인식 가능 종류 개수를 넘으면
                result = Math.max(nowLen, result); // 최대 길이 업데이트
                char minAlpha = findMin(); // 가장 출현 위치가 낮은 문자 찾기
                
                nowLen = i - alpha[minAlpha - 'a']; //현재 인식 길이 업데이트
                alpha[minAlpha-'a'] = -1; // 가장 낮은 출현위치를 -1로 설정
                set.remove(minAlpha); // 인식 가능한 문자열에서 지우기
                
                set.add(next); //새로운 문자 인식 가능 집합에 넣기 
            }else{
                if(!set.contains(next)) nowKind++; // 현재 인식 가능 종류에 없었으면
                set.add(next);
                nowLen++;
                result = Math.max(nowLen, result);
            }
            alpha[next-'a'] = i; //최종 출현 위치 업데이트
        }
        System.out.println(result);
    }

    // 가장 출현 위치가 낮은 문자를 찾는 메서드
    static char findMin() {
        int min = Integer.MAX_VALUE;
        char c = 'a'; //임시 값 ( 아무 값이나 넣어둠)
        for(int i=0 ;i<alpha.length; i++){
            if(alpha[i]!=-1 && alpha[i] < min){
                min = alpha[i];
                c = (char)('a' + i);
            }
        }
        return c;
    }
}