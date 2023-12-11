import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();
        String[] n = N.split(" ");//String 배열
        int[] M = new int[n.length];
        for (int i=0;i<n.length;i+=1){//int 배열
            M[i] = Integer.valueOf(n[i]);
        }

        int w=1,z=M.length,x=M.length;
        for (int i=0;i<n.length;i+=1){
            if (M[i] == w){
                w+=1;
            }
            if (M[i] == x){
                x-=1;
            }
        }

        if (w==9){
            System.out.println("ascending");
        } else if (x==0) {
            System.out.println("descending");
        }else {
            System.out.println("mixed");
        }
        
    }
}