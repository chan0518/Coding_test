import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i=2; N > 1; i++){
            if (N % i == 0) {
                System.out.println(i);
                N /= i;
                i = 1;
            }
        }
    }
}