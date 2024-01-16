import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.valueOf(sc.next());
        int b = Integer.valueOf(sc.next());
        int A = Math.max(a,b);
        int B = Math.min(a,b);

        while (B!=0){
            int r = A % B;
            A = B;
            B = r;
        }

        System.out.println(A);
        System.out.println(a * b / A);
    }
}
