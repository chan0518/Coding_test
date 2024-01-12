import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (true){
            String[] n = sc.nextLine().split(" ");
            int[] m = new int[3];
            m[0] = Integer.valueOf(n[0]);
            m[1] = Integer.valueOf(n[1]);
            m[2] = Integer.valueOf(n[2]);
            if (m[0]==0 && m[1]==0 && m[2]==0) break;
            Arrays.sort(m);

            System.out.println(m[2]*m[2] == m[1]*m[1] + m[0]*m[0] ? "right":"wrong");
        }
    }
}