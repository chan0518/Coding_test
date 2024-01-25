import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.next());
        int K = Integer.valueOf(sc.next());
        int a = 0;
        int array[] = new int[N];
        for (int i=1; i<=N; i++){
            if (N%i == 0) {
                array[a++] = i;
            }
        }
        System.out.println(array[K-1]);
    }
}