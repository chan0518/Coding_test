import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a[][] = new int[9][9];

        int max = 0, x=0, y=0;
        for (int i=0; i<a.length; i++){
            for (int j=0; j<a[0].length; j++){
                a[i][j] = sc.nextInt();
                if (max < a[i][j]){
                    max = a[i][j];
                    x = j;
                    y = i;
                }
            }
        }
        ++x; ++y;
        System.out.println(max);
        System.out.println(y+" "+x);
    }
}