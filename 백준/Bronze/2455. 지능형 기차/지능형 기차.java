import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int max = 0;
        for (int i=0; i<4; i++){
            String str[] = br.readLine().split(" ");
            int a = Integer.valueOf(str[0]);
            int b = Integer.valueOf(str[1]);

            sum -= a;
            sum += b;
            max = Math.max(max, sum);
        }
        bw.write(String.valueOf(max));
        bw.close();
    }
}
