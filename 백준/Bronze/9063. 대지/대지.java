import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] a = new int[N];
        int[] b = new int[N];
        for (int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            a[i] = Integer.valueOf(st[0]);
            b[i] = Integer.valueOf(st[1]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int garo = a[N-1] - a[0];
        int sero = b[N-1] - b[0];
        System.out.println(garo * sero);
    }
}