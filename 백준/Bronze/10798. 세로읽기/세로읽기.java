import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String array1[][] = new String[5][15];
        for (int i=0; i<5; i++){
            for (int j=0; j<15; j++){
                array1[i][j] = "#";
            }
        }//배열을 모두 #으로 초기화

        for (int i=0; i<5; i++){
            String array2[] = br.readLine().split("");
            for (int j=0; j<15; j++){
                if (j >= array2.length) break;
                array1[i][j] = array2[j];
            }
        }//입력 받은 값을 #대신 바꿔 넣음

        for (int j=0; j<15; j++){
            for (int i=0; i<5; i++){
                if ("#".equals(array1[i][j])) continue;
                bw.write(array1[i][j]);
                bw.flush();
            }
        }
        bw.close();
    }
}
