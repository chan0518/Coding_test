import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        int N = Integer.valueOf(a[0]);
        int K = Integer.valueOf(a[1]);

        String Sarr[] = br.readLine().split(" ");
        int arr[] = new int[N];
        for (int i=0; i<N; i++){
            arr[i] = Integer.valueOf(Sarr[i]);
        }
        Arrays.sort(arr);

        bw.write(String.valueOf(arr[N-K]));
        bw.flush();
        bw.close();
    }
}
