import java.io.*;

public class Main {
    public static int Pactorial(int a){
        int sum=1;
        for (int i=a; i>=1; i--){
            sum = sum * i;
        }
        return sum;
    }
    public static int Combination(int a, int b){//5 C 2
        int sum=1;
        for (int i=a; i>a-b; i--){
            sum = sum * i;
        }
        return sum / Pactorial(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        int N = Integer.valueOf(a[0]);
        int K = Integer.valueOf(a[1]);

        bw.write(String.valueOf(Combination(N, K)));
        bw.close();
    }
}