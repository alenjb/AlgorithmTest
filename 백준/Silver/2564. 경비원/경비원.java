import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int [][] arr = new int[num][2];
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int dy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int i=0; i<num; i++){
            int a = arr[i][0];
            int b = arr[i][1];
            //위치가 같으면
            if(a == dy){
                answer += Math.abs(b - dx);
            }else if((Math.abs(a-dy)==1) && ((a + dy == 3) || (a + dy == 7))){
                if(a + dy == 3) answer+= length + Math.min(2* width-dx-b, dx+b);
                else answer+= width + Math.min(2*length-dx - b, dx+b);
            }else if((dy==1 && a== 3) || (dy==3 && a== 1)){
                answer+= dx + b;
            }else if((dy==2 && a== 4) || (dy==4 && a== 2)){
                answer+= length + width - dx - b;
            }else if((dy==3 && a== 1) || (dy==4 && a== 2)){
                answer+= length - dx +b;
            }else if(dy==1 && a== 4){
                answer+= width - dx +b;
            }else if(dy==2 && a== 3){
                answer+= length + dx -b;
            }else if(dy==3 && a== 2){
                answer+= length - dx +b;
            }else if(dy==4 && a== 1){
                answer+= width + dx -b;
            }
        }
        bw.write(answer+"");
        bw.flush();
    }
}
