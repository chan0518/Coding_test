import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.valueOf(br.readLine());
        int sum = 0;

        for (int i=0; i<N; i++){
            int a = Integer.valueOf(br.readLine());
            sum += a;
        }

        bw.write(String.valueOf(sum-N+1));
        bw.close();
    }
}