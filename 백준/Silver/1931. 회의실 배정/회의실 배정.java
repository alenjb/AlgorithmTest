import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        //시작이 가능한 것
            // 그 중에 끝나는 시간이 가장 짧은 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Conf> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Conf(s,e));
        }

        int now = 0;
        int count = 0;
        while(!pq.isEmpty()){
            Conf poll = pq.poll();
            if(now<=poll.start){
                now = poll.end;
                count++;
            }
        }

        bw.write(count+"\n");
        bw.flush();
    }
}
class Conf implements Comparable<Conf>{
    int start;
    int end;
    public Conf(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Conf c){
        if(this.end == c.end) return this.start - c.start;
        return this.end - c.end;
    }
}
