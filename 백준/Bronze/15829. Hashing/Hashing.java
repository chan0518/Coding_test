import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int M = 1234567891;
        long result = 0;
        int N = Integer.valueOf(br.readLine());
        String[] str = br.readLine().split("");
        long pow = 1;
        for (int i=0; i<N; i++){
            long alpha = (long) str[i].charAt(0) - 96 % M;
            result += alpha * pow % M;
            pow = pow * 31 % M;
        }
        System.out.println(result % M);
    }
}