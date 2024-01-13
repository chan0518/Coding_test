import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] a = sc.nextLine().split(" ");
        String[] b = sc.nextLine().split(" ");
        String[] c = sc.nextLine().split(" ");

        int[] A = new int[3];
        int[] B = new int[3];

        A[0] = Integer.valueOf(a[0]);
        A[1] = Integer.valueOf(b[0]);
        A[2] = Integer.valueOf(c[0]);

        B[0] = Integer.valueOf(a[1]);
        B[1] = Integer.valueOf(b[1]);
        B[2] = Integer.valueOf(c[1]);

        int x = A[0];
        if (A[0] == A[1]) x = A[2];
        else if (A[0] != A[1] && A[0] == A[2]) x = A[1];

        int y = B[0];
        if (B[0] == B[1]) y = B[2];
        else if (B[0] != B[1] && B[0] == B[2]) y = B[1];

        System.out.println(x+" "+y);
    }
}