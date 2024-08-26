import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //단어의 개수
		int [] alpha = new int[26]; // 알파벳 가중치 배열
		int result = 0; //결과
		Set<Character> set = new HashSet<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int tc=0; tc<T; tc++) {
			String line = sc.next();
			for(int i=0; i<line.length(); i++) {
				char now = line.charAt(i);
				set.add(now);
				int w = (int) Math.pow(10, line.length()-i-1);
				alpha[now-65] += w; // 가중치 더하기
			}
		}
		
		for(char c : set) pq.add(new Node(c, alpha[c-65]));
		
		int num = 9; // 현재 할당할 숫자
		while(!pq.isEmpty()) {
			Node node =pq.poll();
			result += node.weight * num; // 가중치를 곱해서 더하기
			num--; //할당할 숫자 줄여주기
		}
		System.out.println(result);		
	}
}
class Node implements Comparable<Node>{
	char alphabet;
	int weight;
	public Node(char alphabet, int weight) {
		this.alphabet = alphabet;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		return o.weight - this.weight;
	}
	
}