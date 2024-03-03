import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        while (!a.equals("END")){
            String b[] = a.split("");
            for (int i=a.length()-1; i>=0; i--){
                bw.write(b[i]);
            }
            bw.newLine();
            a = br.readLine();
        }
        bw.close();
    }
}