import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        int a = 300;
        int b = 60;
        int c = 10;

        int A=0,B=0,C=0;

        int num = 0;
        if (T%10 != 0){
            bw.write("-1");
            bw.close();
        }else {
            if (T >= a) {
                A = T/a;
                T = T%a;
            }
            if (T >= b){
                B = T/b;
                T %= b;
            }
            if (T >= c){
                C = T/c;
                T %= c;
            }
            String result = String.valueOf(A)+" "+String.valueOf(B)+" "+String.valueOf(C);
            bw.write(result);
            bw.close();
        }
    }
}