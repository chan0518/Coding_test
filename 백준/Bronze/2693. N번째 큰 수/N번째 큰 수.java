import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < N; j++) {
            String[] str = sc.nextLine().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.valueOf(str[i]);
            Arrays.sort(arr);
            System.out.println(arr[arr.length-3]);
        }
    }
}