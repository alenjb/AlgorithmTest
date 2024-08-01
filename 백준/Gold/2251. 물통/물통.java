import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int maxA;
    static int maxB;
    static int maxC;
    static Set<Status> visited;
    static Set<Integer> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());

        visited = new HashSet<>();
        results = new HashSet<>();

        // Start pouring from (0, 0, maxC)
        pour(0, 0, maxC);

        // Print results in sorted order
        List<Integer> sortedResults = new ArrayList<>(results);
        
        Collections.sort(sortedResults);

        for (int result : sortedResults) {
            bw.write(result+" ");
        }
        bw.flush();
        bw.close();
    }

    static void pour(int a, int b, int c) {
        Status current = new Status(a, b, c);
        if (visited.contains(current)) {
            return;
        }

        visited.add(current);

        if (a == 0) {
            results.add(c);
        }

        // a -> b
        if (a > 0 && b < maxB) {
            int amount = Math.min(a, maxB - b);
            pour(a - amount, b + amount, c);
        }

        // a -> c
        if (a > 0 && c < maxC) {
            int amount = Math.min(a, maxC - c);
            pour(a - amount, b, c + amount);
        }

        // b -> a
        if (b > 0 && a < maxA) {
            int amount = Math.min(b, maxA - a);
            pour(a + amount, b - amount, c);
        }

        // b -> c
        if (b > 0 && c < maxC) {
            int amount = Math.min(b, maxC - c);
            pour(a, b - amount, c + amount);
        }

        // c -> a
        if (c > 0 && a < maxA) {
            int amount = Math.min(c, maxA - a);
            pour(a + amount, b, c - amount);
        }

        // c -> b
        if (c > 0 && b < maxB) {
            int amount = Math.min(c, maxB - b);
            pour(a, b + amount, c - amount);
        }
    }
}

class Status {
    int a, b, c;

    public Status(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Status status = (Status) obj;
        return a == status.a && b == status.b && c == status.c;
    }

    @Override
    public int hashCode() {
        return 31 * a + 31 * b + 31 * c;
    }

}
