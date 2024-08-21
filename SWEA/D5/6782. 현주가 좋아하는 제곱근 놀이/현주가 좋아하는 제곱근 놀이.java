import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		Queue<Node> q = new LinkedList<>();
		
		for(int tc = 1; tc<=T; tc++) {
			long N = Long.parseLong(br.readLine());
			long result = Long.MAX_VALUE;
			
			
			q.add(new Node(N, 0));
			
			while(!q.isEmpty()) {
				Node node = q.poll();
				long num = node.num;
				long depth = node.depth;
				if(num == 2) {
					if(result > depth) result = depth;
					break;
				}
				long plusTimes = 0;
				long pow;
				if(Math.sqrt(num) % 1 !=0) { // 안나눠 떨어지면
					pow = (long) Math.sqrt(num)+1; // 루뜨 씌우고 +1
					plusTimes = (long) Math.pow(pow, 2) - num; // 제곱하고 -num
					q.add(new Node((long) Math.pow(pow, 2), depth+plusTimes));
				}else {
					pow = (long) Math.sqrt(num);
					if(pow>=1 && pow<=Long.MAX_VALUE) {
						q.add(new Node(pow, depth+1));}
				}
				
			}
			q.clear();			
			sb.append("#").append(tc).append(" ").append(result).append("\n");			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static boolean contain(Set<Long>set, Long num) {
		long size = set.size();
		set.add(num);
		if(set.size()!=size) {
			set.remove(num);
			return false;
		}
		set.remove(num);
		return true;
	}

}
class Node{
	long num;
	long depth;
	public Node(long num, long depth) {
		this.num = num;
		this.depth = depth;
	}
	
	
}