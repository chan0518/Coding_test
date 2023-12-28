import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] b = sc.nextLine().split(" ");

        int cnt=0;
        for (int i=0; i<b.length;i++){
            if (b[i].equals(a)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}