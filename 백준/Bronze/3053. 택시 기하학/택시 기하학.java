import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double N = Double.valueOf(br.readLine());
        double pi = Math.PI;

        double a = N*N*pi;
        double b = 2*N*N;

        String formatA = String.format("%.6f", a);
        String formatB = String.format("%.6f", b);

        bw.write(formatA);
        bw.newLine();
        bw.write(formatB);

        br.close();
        bw.close();
    }
}
