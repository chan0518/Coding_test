import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");
        int N = Integer.valueOf(a[0]), n = 8;//9
        int M = Integer.valueOf(a[1]), m = 8;//9

        int Nn = N - n + 1;//2
        int Mm = M - m + 1;//2
        int min = 999;

        String arr[][] = new String[N][M];
        for (int i = 0; i < N; i++) {
            String Iarr[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Iarr[j];
            }
        }//값 저장
        for (int k = 0; k < Nn; k++) {
            for (int h = 0; h < Mm; h++) {
                int Wcnt = 0;//[0,0]이 W인 보드에서 틀린 갯수
                int Bcnt = 0;//[0,0]이 B인 보드에서 틀린 갯수
                for (int i = k; i < k+8; i++) {
                    for (int j = h; j < h+8; j++) {
                        if (i % 2 == 0) {//i가 짝수 일 때
                            if (j % 2 == 0) {//j가 짝수 일 때
                                if (arr[i][j].equals("W")) Bcnt++;
                                else Wcnt++;
                            } else {//j가 홀수 일 때
                                if (arr[i][j].equals("B")) Bcnt++;
                                else Wcnt++;
                            }
                        } else {//i가 홀수 일 떄
                            if (j % 2 != 0) {//j가 홀수 일 때
                                if (arr[i][j].equals("W")) Bcnt++;
                                else Wcnt++;
                            } else {//j가 짝수 일 때
                                if (arr[i][j].equals("B")) Bcnt++;
                                else Wcnt++;
                            }
                        }
                    }
                }
                int num = Math.min(Bcnt, Wcnt);
                min = Math.min(num, min);
            }
        }
        bw.write(String.valueOf(min));
        bw.newLine();
        bw.close();
    }
}