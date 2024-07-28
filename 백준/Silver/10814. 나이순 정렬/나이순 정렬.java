import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

       int N = Integer.parseInt(br.readLine());
       ArrayList<Member> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //i는 하나씩 증가하므로 인덱스라 할 수 있다.
            list.add(new Member(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list); //정렬

        for(int i = 0; i < N; i++) {
            bw.write(list.get(i).toString());
        }

        br.close();

        bw.flush();
        bw.close();

    }
}
//회원 클래스
class Member implements Comparable<Member>{ 
    int index ; // 등록 순서
    int age; //나이
    String name; //이름

    public Member(int index, int age, String name) {
        this.index = index;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        if (this.age != o.age) return this.age - o.age; //만약 나이가 다를 경우는 나이 순으로 정렬하고
        else return this.index - index; //나이가 동일할 경우는 등록 순서대로 출력한다.
    }

    public String toString() {
        return age + " " + name + "\n";
    }
}