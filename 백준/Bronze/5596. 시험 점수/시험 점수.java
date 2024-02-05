import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String aa[] = br.readLine().split(" ");
        String bb[] = br.readLine().split(" ");

        int Asum = 0;
        int Bsum = 0;
        for (int i=0; i<4; i++){
            Asum += Integer.valueOf(aa[i]);
        }
        for (int i=0; i<4; i++){
            Bsum += Integer.valueOf(bb[i]);
        }

        bw.write(Asum > Bsum ? String.valueOf(Asum):String.valueOf(Bsum));
        bw.close();
    }
}
