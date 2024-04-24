import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(arr);
        
        int limit = (int) Math.round((double)N * 0.15);
        int sum = 0;
        for (int i=limit; i<N-limit; i++) sum += arr[i];
        N -= 2*limit;
        double avg = (double) sum/ (double) N;
        System.out.println((int) Math.round(avg));
    }
}
