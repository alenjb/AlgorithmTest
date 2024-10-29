import org.w3c.dom.ls.LSException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int [][] chickToHome;
    static int result = Integer.MAX_VALUE;
    static int N, M;
    static List<int []> chickens = new ArrayList<>(); // 치킨 집 좌표
    static List<int []> homes = new ArrayList<>(); // 집 좌표
    static List<List<Integer>> resultList = new ArrayList<>();
    static List<Integer> currentList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행 열 값
        M = Integer.parseInt(st.nextToken()); //최대 치킨 개수

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1) homes.add(new int[]{i, j});
                else if(now == 2) chickens.add(new int[]{i, j});
            }
        }

        // 거리 베열 구하기
        chickToHome = new int[chickens.size()][homes.size()];
        for(int i=0; i<chickens.size(); i++){
            for(int j=0; j< homes.size(); j++){
                int [] ch = chickens.get(i);
                int [] h = homes.get(j);
                int dist = Math.abs(ch[0] - h[0]) + Math.abs(ch[1] - h[1]);
                chickToHome[i][j] = dist;
            }
        }

//        System.out.println(Arrays.deepToString(chickToHome));

        for(int i=0; i< chickens.size(); i++){
            comb(0, i);
        }
//        System.out.println("currentList = " + resultList);

        for(List<Integer> cur : resultList){
            int totalDist = 0;
            int [] dist = new int[homes.size()];
            Arrays.fill(dist, 9999999);
            // 현재 집과 치킨의 거리 큰 수로 초기화된 상태
            for(int num : cur){ //치킨의 위치
                for(int i=0; i< homes.size(); i++){
//                    System.out.println("num + \" \"+i +\" \"+dist.si = " + num + " " + i + " " + dist.length);
                    int nowDist = chickToHome[num][i];
                    dist[i] = Math.min(nowDist, dist[i]);
                }
            }

            for(int i=0; i< homes.size(); i++) totalDist += dist[i];
            result = Math.min(result, totalDist);
        }

        System.out.println(result);


    }

    static void comb(int depth, int start){
     if(depth == M) {
         List<Integer> list = new ArrayList<>(currentList);
         resultList.add(list);
//         System.out.println("완성"+currentList);
     }else {
         for(int i=start; i<= chickens.size()-1; i++){
//             System.out.println("start = " + start);
             currentList.add(i);
             comb(depth+1, i+1);
             currentList.remove(currentList.size()-1);
         }
     }
    }
}