import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            int a = Integer.valueOf(sc.next());
            int b = Integer.valueOf(sc.next());
            if (a==0 && b==0) break;
            else System.out.println(a+b);
        }
    }
}
