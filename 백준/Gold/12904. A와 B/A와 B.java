import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    //12904번
	public static void main(String[] args) throws Exception {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack = new Stack<>();
        String from = br.readLine();
        String to = br.readLine();
        int fromLength = from.length();
        int result = 0;
        
        stack.push(to);
        
        while(true) {
        	String now = stack.pop();
        	if(now.equals(from)) {
        		result = 1;
        		break;
        	}
        	else if(now.length()>fromLength) {
        		if(now.charAt(now.length()-1) == 'A') {
        			stack.push(now.substring(0, now.length()-1));
        		}
        		//리버스
        		else {
        			stack.push(reverse(now.substring(0, now.length()-1)));
        		}
        	}else if(stack.size() ==0) break;
        }
        bw.write(result+"\n");
        bw.flush();
        
    }
	static String reverse(String s) {
		String newS ="";
		for(int i=s.length()-1; i>=0; i--) {
			newS += s.charAt(i);
		}
		return newS;
	}

}
