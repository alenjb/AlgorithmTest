import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		M  =sc.nextInt();  
		N  =sc.nextInt(); 
		int K  =sc.nextInt(); 
		int [][] arr = new int[M][N];
		boolean [][] visited = new boolean[M][N];
		int [] dr = {0, 1, -1, 0};
		int [] dc = {-1, 0, 0, 1};
		
		
		for(int i=0; i<K; i++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();
			int rightX = sc.nextInt();
			int rightY = sc.nextInt();
			
			for(int rr=leftY; rr<=rightY-1; rr++) {
				for(int cc = leftX; cc<=rightX-1; cc++) {
					arr[rr][cc] = 1;
					visited[rr][cc] = true;
				}
			}
			
		}
		
		// BFS
		Queue<int []> q = new ArrayDeque<>();
		int partition = 0; // 몇개로 나눠져 있는지
		List<Integer> list = new ArrayList<>(); //면적들
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]) continue;
				int tmp = 0 ;// 임시 면적
				partition++;
				q.add(new int [] {i,j});
				while(!q.isEmpty()) {
					int [] poll = q.poll();
					int r = poll[0];
					int c = poll[1];
					if(visited[r][c]) continue;
					visited[r][c] = true;
					tmp++;
					for(int k=0; k<4; k++) {
						int newR = r + dr[k];
						int newC = c + dc[k];
						if(check(newR, newC) && !visited[newR][newC] && arr[newR][newC] == 0) {
							q.add(new int [] {newR, newC});
						}
					}
				}
				list.add(tmp);				
			}
		}
		
		sb.append(partition).append("\n");
		Collections.sort(list);
		for(int num : list) sb.append(num).append(" ");
		System.out.println(sb);
		
		
	}
	
	static boolean check(int r, int c) {
		return r >=0 && r<M && c>=0 && c<N;
	}

}