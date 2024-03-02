import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int arr[] = new int[N+1];
        if (N == 0) bw.write("0");
        else if (N == 1) bw.write("1");
        else {
            arr[1] = 1;
            for (int i=0; i<N-1; i++){
                arr[i+2] = arr[i] + arr[i+1];
            }
            bw.write(arr[N]+"\n");
        }
        bw.close();
    }
}
