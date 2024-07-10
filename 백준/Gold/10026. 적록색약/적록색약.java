import java.util.*;
import java.io.*;
public class Main {
	static int count = 0;
	static int count2 = 0;
	static char [][] arr;
	static char [][] arr2;
	static boolean [][] visited;
	static boolean [][] visited2;
	static int num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = Integer.parseInt(st.nextToken());
		arr = new char [num][num];
		visited = new boolean [num][num];
		arr2 = new char [num][num];
		visited2 = new boolean [num][num];
		
		for(int i=0; i<num; i++) {
			String line = br.readLine();
			for(int j=0; j<num; j++) {
				char a = line.charAt(j);
				arr[i][j] = a;
				arr2[i][j] = a;
			}
		}
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(!visited[i][j]) {
					dfs(j, i);
					count++;
				}
				if(!visited2[i][j]) {
					dfs2(j, i);
					count2++;
				}
			}
		}
		bw.write(count2+" ");
		bw.write(count+"\n");
		bw.flush();
	}
	// 색약
	static void dfs(int x, int y) {
		int [] dx = {-1, 0, 0, 1};
		int [] dy = {0, -1, 1, 0};
		char color = arr[y][x];
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			if(nowX >=0 && nowX < num && nowY >=0 && nowY < num && !visited[nowY][nowX]) {
				if((color == 'R' || color == 'G') && 
						(arr[nowY][nowX] == 'R' || arr[nowY][nowX] == 'G')) { 
					dfs(nowX, nowY);
				} else if(color == 'B' && arr[nowY][nowX] == 'B') {
					dfs(nowX, nowY);
				}
			}
		}
		
	}
	// 정상
	static void dfs2(int x, int y) {
		int [] dx = {-1, 0, 0, 1};
		int [] dy = {0, -1, 1, 0};
		char color = arr2[y][x];
		visited2[y][x] = true;
		for(int i=0; i<4; i++) {
			int nowX = x + dx[i];
			int nowY = y + dy[i];
			if(nowX >=0 && nowX < num && nowY >=0 && nowY < num && !visited2[nowY][nowX]) {
				if(color == 'R' && arr2[nowY][nowX] == 'R') {
					dfs2(nowX, nowY);
				} else if(color == 'G' && arr2[nowY][nowX] == 'G') {
					dfs2(nowX, nowY);
				} else if(color == 'B' && arr2[nowY][nowX] == 'B') {
					dfs2(nowX, nowY);
				}
			}
		}
		
	}

}
