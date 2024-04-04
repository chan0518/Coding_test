import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] divisor (int n){
        int[] cnt = new int[n/2];
        int idx = 0;
        for (int i=2; i<=n/2; i++) if (n%i == 0) cnt[idx++] = i;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            int n = Integer.valueOf(br.readLine());
            if (n == -1) break;
            int[] result = divisor(n);
            int result_sum = 0;
            for (int e:result) result_sum += e;
            if (result_sum+1 == n) {
                System.out.print(n + " = 1");
                for (int i=0; result[i] != 0 && i<n/2; i++) System.out.print(" + "+result[i]);
            }
            else System.out.print(n+" is NOT perfect.");
            System.out.println();
        }
    }
}