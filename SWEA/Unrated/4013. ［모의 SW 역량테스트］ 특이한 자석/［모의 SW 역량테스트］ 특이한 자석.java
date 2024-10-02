import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static Node [] arr = new Node[4];
    static int result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            result = 0;
            sb.append("#").append(tc).append(" ");

            for(int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine());
                Node node = new Node();
                for(int j=0; j<8; j++){
                    int num = Integer.parseInt(st.nextToken());
                    node.wheels[j] = num;
                }
                node.leftIdx = 6;
                node.rightIdx = 2;
                arr[i] = node;
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int dir = Integer.parseInt(st.nextToken());
                move(num, dir, 3);
            }
            calculate();
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    //from이 1이면 왼쪽에서 온거, 2이면 오른쪽에서 온거, 3이면 시작임
    static void move(int num, int dir, int from){
        int wasLeftIdx = arr[num].leftIdx;
        int wasRightIdx = arr[num].rightIdx;

        // 현재꺼 돌리기
        if(dir == 1){// 시계방향
            arr[num].leftIdx--;
            if(arr[num].leftIdx<0) arr[num].leftIdx = 7;
            arr[num].rightIdx--;
            if(arr[num].rightIdx<0) arr[num].rightIdx = 7;
        }else { // 반시게 방향
            arr[num].leftIdx++;
            if(arr[num].leftIdx>7) arr[num].leftIdx = 0;
            arr[num].rightIdx++;
            if(arr[num].rightIdx>7) arr[num].rightIdx = 0;
        }

        //왼쪽 검사 :from이 2번이나 3번인 경우
        if( (from == 2 || from ==3) && num>0 && arr[num-1].wheels[arr[num-1].rightIdx]!= arr[num].wheels[wasLeftIdx]){// 달랐으면
            move(num-1, -dir, 2);
        }
        //오른쪽 검사 :from이 1번이나 3번인 경우
        if( (from == 1 || from ==3) && num<3 && arr[num+1].wheels[arr[num+1].leftIdx] != arr[num].wheels[wasRightIdx]){// 달랐으면
            move(num+1, -dir, 1);
        }
    }
    static void calculate(){
        for(int num=0; num<4; num++){
            int topIdx = (arr[num].leftIdx + 2 >=0 && arr[num].leftIdx + 2 < 8) ? arr[num].leftIdx + 2: arr[num].rightIdx - 2;
            int top = arr[num].wheels[topIdx];

            if(top != 0){
                int tmpResult = (int) Math.pow(2, num);
                result += tmpResult;
            }

        }
    }
    static class Node{
        int leftIdx;
        int rightIdx;
        int [] wheels;

        public Node() {
            wheels = new int[8];
        }
    }
}