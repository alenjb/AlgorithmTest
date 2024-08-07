import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()); //한 줄 읽ㄱ기
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken()) -1;
		int y2 = Integer.parseInt(st.nextToken()) -1;
		
		int min = Math.min(x1, y1);
		int max = Math.max(x2, y2);
		
		long result = 0;

		for(int i=min; i<=max; i++) {
			if(i % 2 == 1) {
				int column = 0;
				int row = 0;
				
				if(i>= x1 && i<= x2) {
					
					if(i >= y1) { //
						int tmp = Math.min(i, y2);
						if(tmp>0) column = tmp - y1 +1;	
					}else {
						column = 0;										
					}					
				}
				if(i>= y1 && i<= y2) {				
					if(i >= x1) {
						int tmp = Math.min(i, x2);
						if(tmp>0) row = tmp - x1 +1;			
					}else {
						row = 0;									
					}
					
					if(row >0 && column>0) result--;
				}
				result = result + row + column;							


			}
		}
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

}
