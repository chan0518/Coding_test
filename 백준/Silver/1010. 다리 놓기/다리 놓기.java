import java.io.*;

class Main {
    public static long C (int m, int n){//mCn
        long result = 1;
        int r = Math.min(m - n, n);
        for (int i=0; i<r; i++) result *= (long)m--;//r만큼 반복
        long R=1;
        for (int i=1; i<=r; i++) R *= i;
        return result/R;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        for (int i=0; i<T; i++){
            String[] str = br.readLine().split(" ");
            int n = Integer.valueOf(str[0]);
            int m = Integer.valueOf(str[1]);
            long result = C(m,n);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}
