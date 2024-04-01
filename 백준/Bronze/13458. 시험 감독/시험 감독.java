import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] a = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i=0; i<N; i++) A[i] = Integer.valueOf(a[i]);
        a = br.readLine().split(" ");
        int B = Integer.valueOf(a[0]);
        int C = Integer.valueOf(a[1]);
        for (int i=0; i<N; i++) A[i] -= B;//총감독관이 관리 할 수 있는 사람 만큼 빼기
        long cnt = N;//초기 총 감독관의 수

        for (int i=0; i<N; i++) {
            if (A[i] > 0) {
                if (A[i] % C == 0) cnt += (long)A[i]/C;
                else cnt += (long)A[i]/C + 1;
            }
        }
        System.out.println(cnt);
    }
}
