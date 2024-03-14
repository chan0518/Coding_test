import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        int M = Integer.valueOf(a[0]);
        int N = Integer.valueOf(a[1]);

        if (M <= 2) {
            bw.write(2+"\n");
            M++;//밑에 출력은 a가 1이면 1부터 출력이 되기 때문에 2부터 소수니까 2로 맞춤
        }

        Loop1:
        for (int i = M; i <= N; i++) {
            if (i%2 == 0) continue;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) continue Loop1;//나머지가 없으니까 소수가 아님 탈락
            }
            bw.write(i+"\n");//소수가 아닌 것들은 위의 break로 이 코드까지 못옴
            //이 코드에 올 수 있는 건 소수라서 if에 안걸러지고 여기까지 옴
        }
        br.close();
        bw.close();
    }
}
