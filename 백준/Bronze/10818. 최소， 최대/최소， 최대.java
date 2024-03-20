import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.valueOf(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i=0; i<arr.length; i++) arr[i] = Integer.valueOf(str[i]);

        Arrays.sort(arr);
        
        bw.write(arr[0]+" "+arr[arr.length-1]);
        
        br.close();
        bw.close();
    }
}
