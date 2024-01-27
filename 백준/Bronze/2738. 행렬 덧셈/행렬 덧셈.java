import java.util.Scanner;

public class Main {
    public static void arrInsert(Scanner sc, int[][] arr){
        for (int i=0; i<arr.length; i++){//b
            for (int j=0; j<arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }
    }
    public static void arrPrint(int a[][], int b[][]){
        for (int i=0; i<a.length; i++){//b
            for (int j=0; j<a[0].length; j++){
                System.out.print(a[i][j] + b[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int a[][] = new int[N][M];
        int b[][] = new int[N][M];

        arrInsert(sc, a);
        arrInsert(sc, b);

        arrPrint(a,b);
    }
}
