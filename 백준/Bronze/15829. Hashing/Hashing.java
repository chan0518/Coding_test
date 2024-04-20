import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        int N = Integer.valueOf(br.readLine());
        String[] str = br.readLine().split("");
        for (int i=0; i<N; i++){
            long alpha = (long) str[i].charAt(0) - 96;
            result += alpha * (long) Math.pow(31, i);
        }
        System.out.println(result % 1234567891);
    }
}