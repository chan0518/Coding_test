import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i=0;i<N;i++){
            int a = i;
            int sum = 0;

            while (a>0){//각 자릿수 합
                sum = sum + a%10;
                a = a/10;
            }
            if (sum+i == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}

