import java.util.ArrayList;
import java.util.Scanner;

public class  Main {
	static int [] truePersons; // 진실을 아는 사람들 배열
	static int [] parent; // 대표번호 배열
	static ArrayList<Integer> [] party;
	static int result = 0;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 사람 수
		int m = sc.nextInt(); // 파티 수
		party = new ArrayList [m];
		
		int knowNum = sc.nextInt(); // 진실을 아는 사람 수
		truePersons = new int[knowNum];
		// 진실을 아는 사람 배열 저장
		for(int i=0; i<knowNum; i++) {
			truePersons[i] = sc.nextInt();
		}
		
		// 파티 배열 저장
		for(int i=0; i<m; i++) {
			party[i] = new ArrayList<>();
			int partySize = sc.nextInt();
			for(int j=0; j<partySize; j++) {
				party[i].add(sc.nextInt());
			}
		}
		
		// 대표번호 배열 초기화
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		// 각 파티에 참여한 사람들을 하나의 그룹으로 만들기
		for(int i=0; i<m; i++) {
			int firstPeople = party[i].get(0);
			for(int j=1; j<party[i].size(); j++) {
				union(firstPeople, party[i].get(j));
			}
		}
		
		//각 파티마다 과장할 수 있는지 계산
		for(int i=0; i<m; i++) {
			boolean isPossible = true;
			int cur = party[i].get(0);
			for(int j=0; j<truePersons.length; j++) {
				if(find(cur) == find(truePersons[j])) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) result++;
		}
		System.out.println(result);
	}
	static int find(int num) {
		if(parent[num] == num) return num;
		else {
			return parent[num] = find(parent[num]);
		}
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}
	static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) {
			return true;
		}
	return false;
	}
}
