import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N1 = Integer.valueOf(br.readLine());
        String[] str1 = br.readLine().split(" ");
        int[] arr1 = new int[N1];
        for (int i=0; i<N1; i++) arr1[i] = Integer.valueOf(str1[i]);

        int N2 = Integer.valueOf(br.readLine());
        String[] str2 = br.readLine().split(" ");
        int[] arr2 = new int[N2];
        for (int i=0; i<N2; i++) arr2[i] = Integer.valueOf(str2[i]);

        Arrays.sort(arr1);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N2; i++) {
            int num = arr2[i];
            int L = 0;
            int R = arr1.length-1;
            int M = 0;
            while (L <= R){
                M = (L + R) /2;

                if (arr1[M] > num) R = M - 1;
                else if (arr1[M] == num) break;
                else L = M + 1;
            }
            if (arr1[M] == num) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}