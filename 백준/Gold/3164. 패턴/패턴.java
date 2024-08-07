import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int x2 = sc.nextInt()-1;
		int y2 = sc.nextInt()-1;
		
		long result = 0;
		for(int i= x1; i<=x2; i++) {
			if(i % 2 ==1) { //검은 색이면
//				//세로
//				System.out.printf("i : %d y1 %d\n",i , y1);
				int column;
				if(i >= y1) { //
					int tmp = Math.min(i, y2);
					column = tmp - y1 +1;	
				}else {
					column = 0;										
				}

				
				result = result += column;			
			}
		}
//		System.out.println("============="+result + "==========================");
		
		for(int i= y1; i<=y2; i++) {
			if(i % 2 ==1) {
				int row;
				if(i >= x1) { //
//					System.out.printf("i : %d x1 %d\n",i , x1);
					int tmp = Math.min(i, x2);
					row = tmp - x1 +1;		
				}else {
					row = 0;									
				}
				result = result += row;							
			}
		}
		
		// 중복 제거
		int a = Math.max(x1, y1);
		int b = Math.min(x2, y2);
		for(int i=a; i<=b; i++) {
			if(i% 2==1) {
//			System.out.println(i + "를 뻄");
//				System.out.println();
				result --;
				
			}
		}
		
		System.out.println(result);
		
	}
}
