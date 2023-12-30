import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        int L=0, P=0;
        L = Integer.valueOf(a[0]);
        P = Integer.valueOf(a[1]);

        String[] b = sc.nextLine().split(" ");
        int[] num = new int[5];
        for (int i=0;i<5;i++){
            num[i] = Integer.valueOf(b[i]);
        }

        for (int i=0;i<5;i++){
            System.out.print(num[i] - L*P + " ");
        }
    }
}