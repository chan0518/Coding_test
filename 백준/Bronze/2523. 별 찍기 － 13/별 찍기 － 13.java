import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        for (int i=0; i<N; i++){
            for (int j=i; j>=0; j--){
                bw.write("*");
                bw.flush();
            }
            bw.newLine();
        }
        for (int k=N-1; k>=0; k--){
            for (int j=k; j>0; j--){
                bw.write("*");
                bw.flush();
            }
            bw.newLine();
        }
        bw.close();
    }
}