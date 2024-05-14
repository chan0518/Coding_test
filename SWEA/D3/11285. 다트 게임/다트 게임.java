
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        double[] arr = new double[10];
        for (int i=1; i<=10; i++) arr[i-1] = 20.0 * (double) i;

        for (int test_case = 1; test_case <= T; test_case++) {
            //code

            int n = Integer.valueOf(br.readLine());
            int score = 0;
            for (int i = 0; i < n; i++) {
                String[] xy = br.readLine().split(" ");
                double x = Double.valueOf(xy[0]);
                double y = Double.valueOf(xy[1]);
                double point = Math.pow(x*x + y*y, 0.5);//  루트(제곱 + 제곱) = 길이 구함
                for (int j=0; j<10; j++) {
                    if (point <= arr[j]) {
                        score += 10 - j;
                        break;
                    }
                }
            }
            System.out.println("#" + test_case + " " + score);


            //code
        }
        br.close();
    }
}