import java.util.*;

class Solution {
    static Stack<Node> recent = new Stack<>(); //최근 삭제 스택
    static Stack<Integer> recentNum = new Stack<>(); //최근 삭제 번호 스택
    static int [] result;
    public String solution(int n, int k, String[] cmd) {
        result = new int [n];
        Map<Integer, Node> nodes = new HashMap<>();
        int cnt = 0; //현재까지 생성된 노드 수
        
        // 연결 리스트 생성
        for(int i=0; i<n; i++){
            if((i == 0)) nodes.put(cnt++, new Node(n-1, i+1));
            else if(i!=n-1) nodes.put(cnt++, new Node(i-1, i+1));
            else nodes.put(cnt++, new Node(i-1, 0));
        }
        
        int now = k;
        
        // 명령 실행
        for(int i=0; i<cmd.length; i++){
            String orders = cmd[i];
            String [] orderA = orders.split(" ");
            char order = orderA[0].charAt(0);
            switch(order){
                // x칸 위행을 선택
                case 'U':
                    int upX = Integer.parseInt(orderA[1]);
                    upX %= n;
                    for(int j=0; j<upX; j++){
                        now = nodes.get(now).prev;            
                    }
                    break;
                // x칸 아래 행을 선택
                case 'D':
                    int downX = Integer.parseInt(orderA[1]);
                    downX %= n;
                    for(int j=0; j<downX; j++){
                        now = nodes.get(now).next;            
                    }
                    break;
                    
                // 현재 행을 삭제한 뒤 아래 행을 선택
                case 'C':
                    // 삭제할 행을 value로 둔 것의 키를 찾아서 그 value를 현재꺼의 value로 바꾸기
                    Node nowNode = nodes.get(now); //이 노드를 이전 노드의 다음꺼로 설정해야함
                    int prevNum = nowNode.prev;
                    int nextNum = nowNode.next;
                    
                    nodes.get(prevNum).next = nextNum;
                    nodes.get(nextNum).prev = prevNum;
                    
                    recent.add(nowNode);
                    recentNum.add(now);
                    
                    if(nextNum < now) now = prevNum; // 마지막 행이면
                    else now = nextNum;                    
                    
                    break;
                    
                // 가장 최근에 삭제된 행을 복구, 선택은 유지
                case 'Z':
                    // 스택에서 빼서 해당꺼의 value로 가서 그 키를 가리키는 거의 valu를 현재꺼로 바꾸기
                    Node delNode = recent.pop();
                    int delNum = recentNum.pop();
                    
                    int prevNum1 = delNode.prev;
                    int nextNum1 = delNode.next;
                    
                    nodes.get(prevNum1).next = delNum;
                    nodes.get(nextNum1).prev = delNum;
                    break;
            }
            
            // System.out.println("order: "+order+" now : "+now);
        }
        
        // 결과 반
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>(recentNum);
        
        int start = -1;
        for(int kk=0; kk<n; kk++){
            if(!set.contains(kk)) {
                start = kk;
                break;
            }
        }
        
        //k부터 시작
        
        for(int i=0; i<n; i++){
            if(set.contains(i)) sb.append("X");
            else sb.append("O");
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    
    static class Node{
        int next;
        int prev;
        
        public Node(int prev, int next){
            this.next = next;
            this.prev = prev;
        }
    }
}