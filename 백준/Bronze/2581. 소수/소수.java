import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.valueOf(br.readLine());
        int N = Integer.valueOf(br.readLine());
        ArrayList<Integer> li =  new ArrayList<>();
        if (M == 1) M=2;
        Loop1:
        for (int i=M; i<=N; i++){
            for (int j=2; j<=(int)Math.sqrt(i); j++){
                if (i % j == 0) continue Loop1;
            }
            li.add(i);
        }
        if (li.isEmpty()) {
            System.out.println(-1);
            return;
        }
        int sum = 0;
        for (int e: li) sum += e;
        int num = li.get(0);
        System.out.println(sum+"\n"+num);
    }
}