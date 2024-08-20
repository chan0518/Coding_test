import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //18, 4
        //4, -1
        //6, 2
        int N = sc.nextInt();//입력
        int a = N/5;
        int b = 0, c = 0;
        boolean TF = false;

        for(;a>0;a--){
            b = N-(5*a);
            if (b%3 == 0) {
                c = b / 3;
                TF = true;
                break;
            }
        }
        if (TF)System.out.println(c + a);
        else if (N%3 == 0) System.out.println(N/3);
        else System.out.println(-1);
    }
}