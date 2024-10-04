import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Num> pq = new PriorityQueue<>();   
        for(int i=0; i<numbers.length; i++){
            pq.add(new Num(numbers[i]+""));
        }
        
        for(int i=0; i<numbers.length; i++){
            String s = pq.poll().num;
            if(i==0 && s.equals("0")) return "0";
            answer+=s;
        }
        return answer;
    }
    
}

class Num implements Comparable<Num>{
    String num;
    public Num(String n){
        this.num = n;
    }
    
    public int compareTo(Num n){
        String front = this.num + n.num;
        String end = n.num + this.num;
        if(Long.parseLong(front) > Long.parseLong(end)) return -1;
        return 1;

    }
}