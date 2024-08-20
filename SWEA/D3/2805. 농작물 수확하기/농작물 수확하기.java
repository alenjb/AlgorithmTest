import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	long result = 0;
        	int size = Integer.parseInt(br.readLine());
        	int [][] arr = new int [size][size];
        	for(int i=0; i<size; i++) {
        		String line = br.readLine();
        		String [] splits = line.split("");
        		for(int j=0; j<size; j++) {
        			arr[i][j] = Integer.parseInt(splits[j]);
        		}
        	}
        	
        	int mid = size / 2;
        	
        	for(int i=0; i<=mid; i++) { //위쪽 ~ 중간
        		for(int j= mid-i; j<=mid+i; j++) {
        			result += arr[i][j];
        		}
        	}

        	for(int i=size-1; i>mid; i--) { // 중간 아래
        		for(int j= mid - (size-1-i); j<=mid + (size-1-i); j++) {
        			result += arr[i][j];
        		}
        	}
        	
        	sb.append("#").append(tc).append(" ").append(result).append("\n");
        	
        } //tc
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}

}