import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Optional;
import java.util.StringTokenizer;

class Main{
    static boolean [] switches;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sl = Integer.parseInt(st.nextToken());
        switches = new boolean[sl];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<sl; i++){
            int now = Integer.parseInt(st.nextToken());
            if(now == 0 ) switches[i] = false;
            else if(now == 1 ) switches[i] = true;
        }
        st = new StringTokenizer(br.readLine());
        int pl = Integer.parseInt(st.nextToken());
        int [][] people = new int[pl][2];
        for(int i = 0; i<pl; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int card = Integer.parseInt(st.nextToken());
            if(gender == 1) man(card);
            else if (gender ==2) woman(card);
        }
        for(int i=0; i<sl; i++){
            int answer;
            if(switches[i]) answer = 1;
            else answer = 0;
            bw.write(answer+" ");
            if((i+1) % 20 ==0) bw.write("\n");
        }
        bw.flush();

    }
    public static void man(int num){
        for(int i=num-1; i<switches.length; i+=num){
            switches[i] = !switches[i];
        }
    }
    public static void woman(int num){
        if(num == 1){
            switches[0] = !switches[0];
        } else if (num == switches.length+1) {
            switches[num-1] = !switches[num-1];
        }else {
            int left = num-2;
            int right = num;
            while (right< switches.length && left >=0 &&switches[left] == switches[right]  ){
                left--;
                right++;
            }
            for(int i=left+1; i<=right-1; i++){
                switches[i] = !switches[i];
            }
        }
    }
}