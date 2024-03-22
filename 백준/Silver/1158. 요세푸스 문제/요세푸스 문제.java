import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String w[] = br.readLine().split(" ");
        int N = Integer.valueOf(w[0]);
        int K = Integer.valueOf(w[1]);

        int arr[] = new int[N+1];
        int result[] = new int[N];
        for (int i=0; i<=N; i++) arr[i] = i;

        int k = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<K; j++) {
                k += 1;
                if (k > N) k -= N;//k값이 N을 넘어가면 배열인덱스를 넘으므로 N을 맞춤
                if (arr[k] == 0) j--;
            }
            while (arr[k] == 0) {
                k += 1;//값이0이면 건너뜀
                if (k > N) k -= N;//k값이 N을 넘어가면 배열인덱스를 넘으므로 N을 맞춤
            }
            result[i] = arr[k];//빼낸 숫자는 result배열에 넣음
            arr[k] = 0;//빼낸 숫자를 result배열에 넣었으니 arr배열에 있는 그 값은 건너뛰기 위해서 0으로 만듦
        }

        bw.write("<");
        for (int i=0; i<N; i++){
            bw.write(String.valueOf(result[i]));
            if (i != N-1) bw.write(", ");
        }
        bw.write(">");
        bw.close();
    }
}