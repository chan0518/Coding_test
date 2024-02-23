import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int arr[][] = new int[N][2];
        for (int i=0; i<N; i++){
            String a[] = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(a[0]);
            arr[i][1] = Integer.valueOf(a[1]);
        }

        Arrays.sort(arr, Comparator.comparingInt((int[]a) -> a[0]).thenComparingInt((int []a) -> a[1]));

        for (int i=0; i<N; i++){
            bw.write(arr[i][0]+" "+arr[i][1]);
            bw.newLine();
        }
        bw.close();
    }
}