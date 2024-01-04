import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        int x = Integer.valueOf(a[0]);
        int y = Integer.valueOf(a[1]);
        int w = Integer.valueOf(a[2]);
        int h = Integer.valueOf(a[3]);

        int garo = (w-x);
        int sero = (h-y);

        if (garo < 0) garo *= -1;
        if (sero < 0) sero *= -1;

        if (x < garo) garo = x;
        if (y < sero) sero = y;

        System.out.println(garo <= sero ? garo:sero);
    }
}