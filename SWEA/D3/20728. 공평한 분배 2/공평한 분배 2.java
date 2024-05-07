
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            //여기 사이에 코드를 넣을 것

            int N = sc.nextInt();
            int K = sc.nextInt();
            long[] arr = new long[N];
            for (int i=0; i<N; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);//정렬
            long result = 1000000000, max = 0, min = 0;
            for (int i=0; i<=N-K; i++){
                min = arr[i];
                max = arr[K-1+i];
                result = Math.min(max - min, result);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#" + tc + " ");
            sb.append(result);
            System.out.println(sb);

            //여기사이에 코드를 넣을 것
        }
    }
}