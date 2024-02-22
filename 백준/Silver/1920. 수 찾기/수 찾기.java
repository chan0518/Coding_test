import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        String a[] = br.readLine().split(" ");

        int M = Integer.valueOf(br.readLine());
        String b[] = br.readLine().split(" ");

        Arrays.sort(a);
        for (int i = 0; i < M; i++) {
            String result = "0";
            int cnt = Arrays.binarySearch(a, b[i]);
            if (cnt >= 0) result = "1";
            bw.write(result);
            bw.newLine();
        }
        bw.close();
    }
}