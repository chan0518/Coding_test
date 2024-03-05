import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        String a[] = br.readLine().split(" ");
        int aa[] = new int[a.length];
        for (int i=0; i<a.length; i++) aa[i] = Integer.valueOf(a[i]);
        Arrays.sort(aa);

        int M = Integer.valueOf(br.readLine());
        String b[] = br.readLine().split(" ");

        for (int i=0; i<M; i++){
            int left = 0;
            int right = N;
            int num = Integer.valueOf(b[i]);
            while (left < right){//하한선 이분탐색
                int mid = (left + right)/2;

                if (num <= aa[mid]) right = mid;
                else left = mid+1;
            }
            int low = left;
            left = 0;
            right = N;
            while (left < right){//상한선 이분탐색
                int mid = (left + right)/2;

                if (num < aa[mid]) right = mid;
                else left = mid+1;
            }
            int high = left;
            int cnt = high - low;

            bw.write(cnt+" ");
        }
        bw.close();
    }
}