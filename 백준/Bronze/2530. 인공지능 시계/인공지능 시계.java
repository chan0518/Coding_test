import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int num = sc.nextInt();
        String[] a = st.split(" ");
        
        int h = Integer.valueOf(a[0]);
        int m = Integer.valueOf(a[1]);
        int s = Integer.valueOf(a[2]);

        m += (s+num)/60;
        s = (s+num)%60;
        
        h += m/60;
        m %= 60;
  
        h %=24;

        System.out.println(h+" "+m+" "+s);
        sc.close();
    }
}