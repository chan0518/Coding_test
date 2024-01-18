import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Ysum=0;
        int Msum=0;

        for (int i=0; i<N; i++){
            int a = Integer.valueOf(sc.next());

            int y;
            y = ((a/30)+1) * 10 ;
            int m;
            m = ((a/60)+1) * 15 ;
            Ysum += y;
            Msum += m;
        }
        if (Ysum == Msum) System.out.println("Y"+" "+"M"+" "+Ysum);
        else System.out.println(Ysum<Msum ? "Y"+" "+Ysum:"M"+" "+Msum);
    }
}
