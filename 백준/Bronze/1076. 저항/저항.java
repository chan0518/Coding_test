import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] color = {"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();

        long A,B,C;
        A = Arrays.asList(color).indexOf(a) * 10;
        B = Arrays.asList(color).indexOf(b);
        C = (long) Math.pow(10,Arrays.asList(color).indexOf(c));

        System.out.println((A+B) * C);
    }
}
