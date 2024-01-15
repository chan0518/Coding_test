import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i=0; i<N; i++){
            String[] a = sc.nextLine().split(",");
            System.out.println(Integer.valueOf(a[0]) + Integer.valueOf(a[1]));
        }
    }
}