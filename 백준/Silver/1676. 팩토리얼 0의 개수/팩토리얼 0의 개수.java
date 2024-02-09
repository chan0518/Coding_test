import java.io.*;
import java.util.Arrays;

public class Main {//10989
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.valueOf(br.readLine());

        bw.write(String.valueOf((a/5) + (a/25) + (a/125)));
        bw.close();
    }
}