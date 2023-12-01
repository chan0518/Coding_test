import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ip[] = input.split(" ");

        int a = Integer.parseInt(ip[0]);
        int b = Integer.parseInt(ip[1]);

        int aa = a/100 + a%100/10*10 + a%10*100;
        int bb = b/100 + b%100/10*10 + b%10*100;

        System.out.println(aa>bb ? aa:bb);
    }
}

