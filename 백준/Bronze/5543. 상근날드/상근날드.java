import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int A = sc.nextInt();
        int B = sc.nextInt();

        int burger = a<=b ? a:b;
        burger = burger<=c ? burger:c;

        int drink = A<=B ? A:B;
        System.out.println(burger+drink-50);
    }
}