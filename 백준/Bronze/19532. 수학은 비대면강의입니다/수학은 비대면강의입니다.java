import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.valueOf(str[0]);
        int b = Integer.valueOf(str[1]);
        int c = Integer.valueOf(str[2]);
        int d = Integer.valueOf(str[3]);
        int e = Integer.valueOf(str[4]);
        int f = Integer.valueOf(str[5]);

        for (int i=-999; i<1000; i++){
            for (int j=-999; j<1000; j++){
                if (a*i + b*j == c && d*i + e*j == f) {
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }

    }
}