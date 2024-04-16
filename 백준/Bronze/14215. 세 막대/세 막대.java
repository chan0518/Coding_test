import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i=0; i<str.length; i++) arr[i] = Integer.valueOf(str[i]);
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        while (a+b <= c) c--;
        System.out.println(a+b+c);
    }
}