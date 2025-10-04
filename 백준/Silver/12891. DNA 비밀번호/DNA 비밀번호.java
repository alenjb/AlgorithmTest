import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int l = sc.nextInt();
            int pw = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();

            int A = sc.nextInt();
            int C = sc.nextInt();
            int G = sc.nextInt();
            int T = sc.nextInt();

            int a = 0;
            int c = 0;
            int g = 0;
            int t = 0;

            for(int i=0; i<pw; i++){
                char ch = line.charAt(i);
                switch(ch){
                    case 'A' :
                        a++;
                        break;
                    case 'C' :
                        c++;
                        break;
                    case 'G' :
                        g++;
                        break;
                    case 'T' :
                        t++;
                        break;
                }
            }

            int left = 0;
            int right = left + pw - 1;
            int answer = 0;
            while(right <=l){
                // 현재꺼 조건 만족 여부
                if(a >=A && c >= C && g >=G && t >=T) answer++;
                // 오른쪽과 왼쪽 조정
                char leftC = line.charAt(left);
                switch(leftC){
                    case 'A' :
                        a--;
                        break;
                    case 'C' :
                        c--;
                        break;
                    case 'G' :
                        g--;
                        break;
                    case 'T' :
                        t--;
                        break;
                }
                if(right + 1 < l){
                    char nextC = line.charAt(right + 1);
                    right++;
                    left++;
                    switch(nextC){
                        case 'A' :
                            a++;
                            break;
                        case 'C' :
                            c++;
                            break;
                        case 'G' :
                            g++;
                            break;
                        case 'T' :
                            t++;
                            break;
                    }
                }else break;
            }
            System.out.println(answer);
        }
}
