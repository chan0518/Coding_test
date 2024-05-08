import java.io.IOException;
import java.util.Scanner;

public class Main {
    static long ff(int N, int r, int c) {
        int M = (int) Math.pow(2, N);
        long value = M * M / 4;

        if (N == 1) {
            if (r == 0 && c == 0) return 0;//2사분면
            else if (r == 0 && c == 1) return 1;//1사분면
            else if (r == 1 && c == 0) return 2;//3사분면
            else if (r == 1 && c == 1) return 3;//4사분면
        }
        M /= 2;
        if (r < M && c < M) return ff(N - 1, r, c);//2사분면
        else if (r < M && c >= M) return value + ff(N - 1, r, c % M);//1사분면
        else if (r >= M && c < M) return value * 2 + ff(N - 1, r % M, c);//3사분면
        else if (r >= M && c >= M) return value * 3 + ff(N - 1, r % M, c % M);//4사분면
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(ff(N, r, c));
    }
}
