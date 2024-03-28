import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int a = sc.nextInt();
            int Quarter = a/25;
            a %= 25;
            int Dime = a/10;
            a %= 10;
            int Nickel = a/5;
            a %= 5;
            int Penny = a/1;
            System.out.printf("%d %d %d %d\n", Quarter,Dime,Nickel, Penny);
        }
    }
}