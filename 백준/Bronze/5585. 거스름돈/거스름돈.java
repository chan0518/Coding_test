import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1000 - sc.nextInt();

        int cnt=0;
        if (N/500 >= 1){
            cnt += N/500;
            N %= 500;
        }
        if (N/100 >= 1) {
            cnt += N/100;
            N %= 100;
        }
        if (N/50 >= 1) {
            cnt += N/50;
            N %= 50;
        }
        if (N/10 >= 1) {
            cnt += N/10;
            N %= 10;
        }
        if (N/5 >= 1) {
            cnt += N/5;
            N %= 5;
        }
        if (N/1 >= 1) {
            cnt += N/1;
            N %= 1;
        }
        System.out.println(cnt);
    }
}
