import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i=0;i<N;i++){//1 3 5 7 9
            for (int j=i;j>0;j--){
                System.out.print(" ");
            }
            for (int j=i*2+1;j<N*2;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}