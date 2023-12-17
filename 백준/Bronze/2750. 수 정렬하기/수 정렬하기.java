import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer[] array = new Integer[N];
        for (int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        for (int e: array){
            System.out.println(e);
        }
        sc.close();
    }
}