import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        String[] st = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.valueOf(st[i]);
        st = br.readLine().split(" ");
        int[] B = new int[N];
        for (int i = 0; i < N; i++) B[i] = Integer.valueOf(st[i]);

        Arrays.sort(A);
        Arrays.sort(B);
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[N-1-i];
        }
        System.out.println(S);
    }
}