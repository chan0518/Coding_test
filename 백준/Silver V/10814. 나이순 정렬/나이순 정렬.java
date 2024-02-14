import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());

        String arr[][] = new String[N][3];

        for (int i=0; i<N; i++){
            String a[] = br.readLine().split(" ");
            arr[i][0] = a[0];
            arr[i][1] = a[1];
            arr[i][2] = String.valueOf(i+1);
        }

        Arrays.sort(arr, Comparator
                .comparingInt((String[] person) -> Integer.valueOf(person[0])));
//                .thenComparing(person -> person[2]));
        for (int i=0; i<N; i++){
            bw.write((arr[i][0])+" "+arr[i][1]);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}