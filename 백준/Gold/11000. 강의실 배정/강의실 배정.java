import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Subject> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Subject(s,e));
        }
        Collections.sort(list);

        for(Subject sb :list){
            if (!pq.isEmpty() && pq.peek() <= sb.start){
                pq.poll();
            }
            pq.add(sb.end);
        }
        bw.write(pq.size()+"\n");
        bw.flush();

    }
}
class Subject implements Comparable<Subject>{
    int start;
    int end;
    public Subject(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Subject subject){
        if(this.start  == subject.start)
            return this.end - subject.end;
        else return this.start - subject.start;
    }
}