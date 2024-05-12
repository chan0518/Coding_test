
import java.util.*;
import java.io.FileInputStream;

class Solution{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //여기 사이에 코드를 넣을 것

            int n = sc.nextInt();
            int sum = 0;
            int[][] arr = new int[n][n];
            for (int i=0; i<n; i++){
                String[] str = sc.next().split("");
                for (int j=0; j<n; j++) arr[i][j] = Integer.valueOf(str[j]);
            }

            boolean size = false;
            int idx=n/2;
            for (int i=0; i<n; i++){
                if (!size){
                    for (int j=n/2 - i; j<= n/2 + i; j++){
                        sum += arr[i][j];
                    }
                    if (n/2-i == 0) size = true;
                }
                else {
                    idx--;
                    for (int j=n/2-idx; j<= n/2+idx; j++) {
                        sum += arr[i][j];
                    }
                }
            }

            System.out.printf("#%d %d\n",test_case, sum);

//2차원배열 출력
//            for (int[] e1: arr){
//                for (int e2: e1) System.out.print(e2 + " ");
//                System.out.println();
//            }

            //여기사이에 코드를 넣을 것
        }
    }
}