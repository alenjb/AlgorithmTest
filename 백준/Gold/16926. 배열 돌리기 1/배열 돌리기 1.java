import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, R;
	static int [][] arr, arr2;
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		R = scanner.nextInt();
		int small = Math.min(N, M);
		arr = new int[N][M];
		arr2 = new int [N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}		
		
		for(int k=0; k<R; k++) {
			for(int i=0, j=M-1, minY=0, maxY=N-1, minX=0, maxX= M-1; 
					i<= (small%2 == 0? small/2-1 : small/2); 
					i++, j--, minX++, minY++, maxX--, maxY--) {
//				System.out.println("minX" + minX+ " minY: "+minY + " maxX : "+maxX+ " maxY: "+maxY);
				rotate(i, j, minY, maxY, minX, maxX);
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					arr[i][j] = arr2[i][j];
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}	

		
	}
	
	// 0, M-1부터 시작
	// 0~ 짝수면 N/2-1 홀수면 N/2
	// N-2 ~ (N-1) - N/2
	static void rotate(int r, int c, int minY, int maxY, int minX, int maxX) {
		if(minX == maxX) {
			arr2[minY][minX] = arr[minY][minX];
			return;
		}
		
		// 위쪽
		for(int i=maxX-1; i>=minX; i--) {
			arr2[minY][i] = arr[minY][i+1];
		}
			
		// 왼쪽 아래로
		for(int i=minY+1; i<= maxY; i++) {
			arr2[i][minX] = arr[i-1][minX];
		}
		

		// 아래쪽
		for(int i=minX+1; i<= maxX; i++) {
			arr2[maxY][i] = arr[maxY][i-1];
		}

				
		// 오른쪽 위로
		for(int i=maxY-1; i>= minY; i--) {
			arr2[i][maxX] = arr[i+1][maxX];
		}
		
//		System.out.println("r "+r+" c: "+c +" "  +Arrays.deepToString(arr2));
				
	}
}