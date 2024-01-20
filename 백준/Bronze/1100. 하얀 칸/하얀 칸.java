import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;

        for (int i=0; i<8; i++){
            String[] a = sc.nextLine().split("");
            for (int j=0; j<8; j++){
                if (i%2==0 && j%2==0 && a[j].equals("F")) cnt++;
                if (i%2==1 && j%2==1 && a[j].equals("F")) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
