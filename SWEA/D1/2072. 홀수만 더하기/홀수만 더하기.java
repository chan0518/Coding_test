
import java.util.*;
import java.io.FileInputStream;

class Solution{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            //여기 사이에 코드를 넣을 것

            int n = 10;

            int sum = 0;
            for (int i=0; i<n; i++) {
                int a = sc.nextInt();
                if (a % 2 == 1) sum += a;
            }
            System.out.printf("#%d %d\n", tc, sum);

            //여기사이에 코드를 넣을 것
        }
    }
}