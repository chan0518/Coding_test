
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        int n = Integer.valueOf(a[0]);
        int k = Integer.valueOf(a[1]);
        int[] arr = new int[n];

        for (int i=n-1; i>=0; i--){
            arr[i] = Integer.valueOf(br.readLine());
        }

        int cnt = 0;
        for (int i=0; i<n; i++){
            if (k >= arr[i]){
                cnt += k/arr[i];
                k %= arr[i];
            }
            if (k == 0) {
                bw.write(String.valueOf(cnt));
                break;
            }
        }
        br.close();
        bw.close();
    }
}
