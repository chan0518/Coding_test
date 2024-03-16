import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        String b[] = br.readLine().split(" ");
        int A = Integer.valueOf(a[0]);
        int B = Integer.valueOf(a[1]);
        int C = Integer.valueOf(b[0]);
        int D = Integer.valueOf(b[1]);

        int result = Math.min(A+D, B+C);
        bw.write(result+"\n");

        br.close();
        bw.close();
    }
}
