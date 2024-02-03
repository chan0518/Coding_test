import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int array[] = new int[5];
        for (int i=0; i<5; i++){
            int a = Integer.valueOf(br.readLine());
            array[i] = a;
            sum += a;
        }
        int avg = sum/5;
        Arrays.sort(array);

        bw.write(String.valueOf(avg));
        bw.newLine();
        bw.write(String.valueOf(array[2]));
        bw.flush();
        bw.close();
    }
}
