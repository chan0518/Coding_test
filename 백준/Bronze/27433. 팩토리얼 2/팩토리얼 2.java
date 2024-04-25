import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.valueOf(br.readLine());
        long num = 1;
        for (long i=N; i>1; i--){
            num *= i;
        }
        System.out.println(num);

    }
}
