import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        int c = Integer.valueOf(br.readLine());

        if (a+b+c == 180){
            if (a == 60 && b == 60 && c == 60) System.out.println("Equilateral");
            else if ((a==b && a!=c) || (b==c && b!=a) || (a==c && a!=b)) System.out.println("Isosceles");
            else if (a != b && a != c && b != c) System.out.println("Scalene");
        }
        else System.out.println("Error");

    }
}