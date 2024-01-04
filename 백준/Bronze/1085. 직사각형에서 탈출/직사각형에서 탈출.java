import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        int x = Integer.valueOf(a[0]);
        int y = Integer.valueOf(a[1]);
        int w = Integer.valueOf(a[2]);
        int h = Integer.valueOf(a[3]);

        int garo = Math.min((w-x),x);
        int sero = Math.min((h-y),y);

        System.out.println(Math.min(garo,sero));
    }
}