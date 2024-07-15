import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception{
		// 1. 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());			
			//n이 소수인지 확인
			if(isSosu(num)) bw.write("0\n");
			else {
				int small = 0;
				int big = 0;
				// 작은 소수 찾기
				for(int j=num-1; j>1; j--) {
					if(isSosu(j)) {
						small = j;
						break;
					}
				}
				
				// 큰 소수 찾기
				for(int j=num+1; j<1299709; j++) {
					if(isSosu(j)) {
						big = j;
						break;
					}
				}
				bw.write((big-small)+"\n");
			}
		}
		bw.write("\n");
		bw.flush();
	}
	static boolean isSosu(int num) {
		if (num == 1 || num == 2) {
            return true;
        } else {
            for (int i = 2; i <= (int)Math.sqrt(num) + 1; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
	}
}
