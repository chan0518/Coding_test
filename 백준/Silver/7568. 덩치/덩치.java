import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        int arr[][] = new int[N][3];
        for (int i=0; i<N; i++){
            String a[] = br.readLine().split(" ");
            arr[i][0] = Integer.valueOf(a[0]);
            arr[i][1] = Integer.valueOf(a[1]);
        }

        for (int i=0; i<N; i++){
            int cnt = 1;
            for (int j=0; j<N; j++){
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
            }
            arr[i][2] = cnt;
        }

        for (int i=0; i<N; i++) bw.write(arr[i][2]+" ");


        br.close();
        bw.close();
    }
}