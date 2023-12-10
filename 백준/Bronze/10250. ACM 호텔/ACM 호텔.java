import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0;i<T;i+=1){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int a = N/H;
            int b = N%H==0 ? H*100:(N%H) * 100+1;

            System.out.println(a+b);
        }
    }
}