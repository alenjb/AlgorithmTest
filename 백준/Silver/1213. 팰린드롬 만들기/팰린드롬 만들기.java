import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int [] alphabets = new int[26]; // idx 0은 65인 A부터 시작
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 입력 받기
        String line = br.readLine();
        String[] inputs = line.split("");
        for (String s : inputs){
            char c = s.charAt(0);
            int idx = c-65;
            alphabets[idx] ++;
        }
        int noPair = 0; // 홀수인 것의 개수
        char noPairAlphabet = 0;
        for(int i=0; i<26; i++){
            int alphabetCnt = alphabets[i];
            char alpha = (char) (i+65);
            if(alphabetCnt % 2 != 0){
                if(alphabetCnt / 2 > 0){ //홀수이지만 1개는 아닌 경우
                    for(int j=0; j<alphabetCnt / 2; j++){
                        sb.append(alpha);
                    }
                }
                noPairAlphabet = (char) (i+65);
                noPair++;
                if(noPair >1){ // 홀수개인 알파벳이 1개를 초과하는 경우
                    bw.write("I'm Sorry Hansoo");
                    bw.flush();
                    bw.close();
                    return;
                }
            }else {
                // 짝수개인 경우
                for(int j=0; j<alphabetCnt / 2; j++){
                    sb.append(alpha);
                }
            }
        }

        //현재까지의 sb 뒤집기
        String reverse = sb.reverse().toString();
        // 다시 원래대로 뒤집기
        sb.reverse().toString();
        // 만약 홀수개인 것이 1개 남았으면
        if(noPair == 1){
            sb.append(new String(String.valueOf(noPairAlphabet)));
        }
        sb.append(reverse);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
