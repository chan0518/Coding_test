import java.util.Scanner;

public class Main {
    static int Y(int y){
        int a = ((y/30)+1) * 10 ;
        return a;
    }
    static int M(int m){
        int a = ((m/60)+1) * 15 ;
        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Ysum=0;
        int Msum=0;

        for (int i=0; i<N; i++){
            int a = Integer.valueOf(sc.next());
            Ysum += Y(a);
            Msum += M(a);
        }
        if (Ysum == Msum) System.out.println("Y"+" "+"M"+" "+Ysum);
        else System.out.println(Ysum<Msum ? "Y"+" "+Ysum:"M"+" "+Msum);
    }
}
