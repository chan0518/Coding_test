import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        int arr[] = new int[N*2];
        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        int idx = 0;
        int add = N;

        while(N-- > 1) {
            idx += 2;
            arr[add + 1] = arr[idx];
            add++;
        }
        bw.write(String.valueOf(arr[add]));
        bw.close();
    }
}