import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        for (int i=0; i<9; i++) arr[i] = Integer.valueOf(br.readLine());
        Arrays.sort(arr);
        int num = 0;
        for (int e: arr) num += e;
        int a = 0, b = 0;

        Loop1:
        for (int i=0; i<8; i++){
            for (int j=i+1; j<9; j++){
                if (num - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break Loop1;
                }
            }
        }
        for (int i=0; i<9; i++) if (i != a && i != b) System.out.println(arr[i]);
    }
}
