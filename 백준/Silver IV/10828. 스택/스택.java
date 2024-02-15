import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int arr[] = new int[N];

        int cnt = -1;
        for (int i=0; i<N; i++){
            String a = br.readLine();
            String b[] = a.split(" ");

            if (b[0].equals("push")){
                if (cnt < 0) cnt=0;
                else cnt++;
                arr[cnt] = Integer.valueOf(b[1]);
            } else if (b[0].equals("pop")) {
                bw.write(cnt < 0 ? "-1":String.valueOf(arr[cnt]));
                bw.newLine();
                if (cnt >= 0) arr[cnt] = 0;
                cnt--;
            } else if (b[0].equals("size")) {
                bw.write(cnt < 0 ? "0":String.valueOf(cnt+1));
                bw.newLine();
            } else if (b[0].equals("empty")) {
                bw.write(arr[0] == 0 ? "1":"0");
                bw.newLine();
            } else if (b[0].equals("top")) {
                bw.write(arr[0] == 0 ? "-1":String.valueOf(arr[cnt]));
                bw.newLine();
            } else if (b[0].equals("print")) {
                bw.write(String.valueOf(arr[cnt]));
                bw.newLine();
            }
        }
        bw.close();
    }
}