import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String a = sc.nextLine();
            if (a.equals("0")) break;

            String b = "";
            for (int i=0;i<a.length();i++){
                b += a.charAt(a.length()-1-i);
            }
            System.out.println(a.equals(b) ? "yes":"no");
        }
    }
}