import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        int result = 0; //최대 별똥별
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Pos> stars = new ArrayList<>();
        List<Pos> mixedStars = new ArrayList<>();

        st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가로
        int M = Integer.parseInt(st.nextToken()); // 세로
        int L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변
        int K = Integer.parseInt(st.nextToken()); // 별똥별 수

        for(int i=0; i<K; i++){
            st= new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            stars.add(new Pos(r,c));
        }

//        if(stars.size()==1) {
//            System.out.println(K-1);
//            return;
//        }

        for(int i=0; i<K; i++){
            for(int j=0; j<K; j++){
//                if(i ==j) continue;
                Pos pos1 = stars.get(i);
                Pos pos2 = stars.get(j);
                mixedStars.add(new Pos(pos1.r, pos2.c));
                mixedStars.add(new Pos(pos2.r, pos1.c));
                mixedStars.add(new Pos((pos1.r + pos2.r)/2, (pos1.c + pos2.c)/2));
            }
        }

        for(int i=0; i<mixedStars.size(); i++) {
            Pos pos = mixedStars.get(i);
            int r = pos.r;
            int c = pos.c;
            int tmpResult = 0;
            int maxR, maxC, minR, minC;

            //왼쪽 아래인 경우
            minR = Math.max(r - L, 0);
            minC = c;
            maxR = r;
            maxC = Math.min(c+L, N);
            for(Pos tmpPos : stars){
                if(check(tmpPos.r, tmpPos.c, maxR, maxC, minR, minC)){
                    tmpResult++;
                }
            }
            if(result< tmpResult){
                result = tmpResult;
//                System.out.println(r+" "+c+" "+"왼아"+tmpResult);
            }
//            result = Math.max(result, tmpResult);


            //오른쪽 아래인 경우
            tmpResult = 0;
            minR = Math.max(r - L, 0);
            minC = Math.max(c - L, 0);
            maxR = r;
            maxC = c;
            for(Pos tmpPos : stars){
                if(check(tmpPos.r, tmpPos.c, maxR, maxC, minR, minC)){
                    tmpResult++;
                }
            }
            if(result< tmpResult){
                result = tmpResult;
//                System.out.println(r+" "+c+" "+"오아"+tmpResult);
            }

            //왼쪽 위인 경우
            tmpResult = 0;
            minR = r;
            minC = c;
            maxR = Math.min(r + L, M);
            maxC = Math.min(c + L, N);
            for(Pos tmpPos : stars){
                if(check(tmpPos.r, tmpPos.c, maxR, maxC, minR, minC)){
                    tmpResult++;
                }
            }
            if(result< tmpResult){
                result = tmpResult;
//                System.out.println(r+" "+c+" "+"왼위"+tmpResult);
            }

            //오른쪽 위인 경우
            tmpResult = 0;
            minR = r;
            minC = Math.max(c - L, 0);
            maxR = Math.min(r + L, M);
            maxC = c;
            for(Pos tmpPos : stars){
                if(check(tmpPos.r, tmpPos.c, maxR, maxC, minR, minC)){
                    tmpResult++;
                }
            }
            if(result< tmpResult){
                result = tmpResult;
//                System.out.println(r+" "+c+" "+"오위"+tmpResult);
            }
        }
        System.out.println(stars.size() - result);


    }
    static boolean check(int r, int c, int maxR, int maxC, int minR, int minC){
        return r>=minR && r<=maxR && c>=minC && c<=maxC;
    }
    static class Pos{
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}