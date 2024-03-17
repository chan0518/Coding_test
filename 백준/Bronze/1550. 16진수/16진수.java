import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str[] = sc.nextLine().split("");
        int arr[] = new int[str.length];

        int sum = 0;
        for (int i=0; i<str.length; i++){
            if (str[i].equals("A") || str[i].equals("a")) arr[i] = Integer.valueOf(10);
            else if (str[i].equals("B") || str[i].equals("b")) arr[i] = Integer.valueOf(11);
            else if (str[i].equals("C") || str[i].equals("c")) arr[i] = Integer.valueOf(12);
            else if (str[i].equals("D") || str[i].equals("d")) arr[i] = Integer.valueOf(13);
            else if (str[i].equals("E") || str[i].equals("e")) arr[i] = Integer.valueOf(14);
            else if (str[i].equals("F") || str[i].equals("f")) arr[i] = Integer.valueOf(15);
            else  arr[i] = Integer.valueOf(str[i]);

            sum += (int)Math.pow(16, str.length-1-i) * arr[i];
        }
        System.out.println(sum);


        sc.close();
    }
}
