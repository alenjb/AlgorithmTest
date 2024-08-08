import java.util.*;

public class Main {
    static int total;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        total = sc.nextInt(); // 가로 및 세로 줄
        int totalPerson = total * total;
        List<Integer> [] likes = new List[totalPerson+1]; // 좋아하는 학생 인접 리스트
        int [] seq = new int[totalPerson]; // 자리 지정 순서 배열
        int [][] classroom = new int[total][total]; // 교실 현재 자리 2차원 배열
        int result = 0; // 정답

        int [] dx = {-1, 0, 0, 1};
        int [] dy = {-0, -1, 1, 0};
        // A형 PQ  우선순위: adj > vacant > row > col
        PriorityQueue<A> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.adjNum != o2.adjNum) return o2.adjNum - o1.adjNum;
            if(o1.vacantNum != o2.vacantNum) return o2.vacantNum - o1.vacantNum;
            if(o1.row != o2.row) return o2.row - o1.row;
            return o2.col - o1.col;
        });

        // 좋아하는 학생 인접 리스트 초기화
        for(int i=0; i<=totalPerson; i++){
            likes[i] = new ArrayList<>();
        }
        // 좋아하는 학생 인접 리스트 입력 받기
        for(int t = 0; t<totalPerson; t++){
            int now = sc.nextInt();
            seq[t] = now;
            for(int a = 0; a<4; a++){
                likes[now].add(sc.nextInt());
            }
        }
        for(int s = 0; s<totalPerson; s++){ //모든 seq에 있는 사람들에 대해
            int p = seq[s]; //현재 자리를 정하는 사람
//            System.out.println(p + "차례");
            //1. 교실에서 한칸씩 검사
            for(int i =0; i<total; i++){
                for(int j=0; j<total; j++){
                    int nowX = j;
                    int nowY = i;
                    if(classroom[nowY][nowX]!=0) continue;
                    List<Integer> likeFour = likes[p];
                    int vac = 0; // 비어있는 인접한 개수
                    int adj = 0; // 좋아하는 인접한 개수
                    for(int k=0; k<4; k++){
                        int newX = j+dx[k];
                        int newY = i+dy[k];
                        if(check(newX, newY)){ //범위 안에 있으면
                            if(classroom[newY][newX] == 0) vac++; // 비어있으면
                            else if(likeFour.contains(classroom[newY][newX])) adj++; //좋아하는 인접한 사람이면
                        }
                    }
                    // 4방 탐색후 PQ에 넣기
                    pq.add(new A(adj, vac, nowY, nowX));
                }
            }
            A poll = pq.poll(); //앉을 사람
//            System.out.println(p+"자리 : "+ poll.row + " " + poll.col);
            classroom[poll.row][poll.col] = p; //착석
            pq.clear();
        }

        //정답 구하기
        for(int i=0; i<total; i++){
            for(int j=0; j<total; j++){
                int nowPerson = classroom[i][j];
                int cnt = 0; // 좋아하는 인접한 개수
                List<Integer> likeFour = likes[nowPerson];
                for(int k=0; k<4; k++){
                    int newX = j+dx[k];
                    int newY = i+dy[k];
                    if(check(newX, newY)){ //범위 안에 있으면
                        if(likeFour.contains(classroom[newY][newX])) cnt++; //좋아하는 인접한 사람이면
                    }
                }
            result += calResult(cnt);
            }
        }
//        for(int i=0; i<total; i++){
//            for(int j=0; j<total; j++){
//                System.out.print(classroom[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("Arrays.toString(classroom) = " + Arrays.toString(classroom));
        System.out.println(result);
    }
    // 범위 내에 있는지 체크
    static boolean check(int x, int y){
        return x>=0 && x<total && y>=0 && y<total;
    }
    static int calResult(int num){
        switch (num){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 10;
            case 3:
                return 100;
            default:
                return 1000;
        }
    }

}
class A{
    int adjNum; // 좋아하는 사람 인접 개수
    int vacantNum; // 비어있는 자리 인접 개수
    int row; // 행
    int col;// 열

    public A(int adjNum, int vacantNum, int row, int col) {
        this.adjNum = adjNum;
        this.vacantNum = vacantNum;
        this.row = row;
        this.col = col;
    }
}
