import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] str = br.readLine().split(" ");
            int[] num = new int[str.length];
            for (int i = 0; i < str.length; i++) num[i] = Integer.valueOf(str[i]);
            Arrays.sort(num);
            int a = num[0];
            int b = num[1];
            int c = num[2];
            if (a==0 && b==0 && c==0) return;

            if (a == b && a == c) System.out.println("Equilateral");
            else if (a+b <= c) System.out.println("Invalid");
            else if (a == b || a == c || b == c) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}