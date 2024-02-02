import java.io.*;

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
                if ("#".equals(array1[i][j])) continue;//값에 #이 나오면 continue로 인해 스킵됌
                bw.write(array1[i][j]);//#이 안나오면 밑에 #대신 바꿔넣은값이 출력됌
                bw.flush();
            }
        }
        bw.close();
    }
}
