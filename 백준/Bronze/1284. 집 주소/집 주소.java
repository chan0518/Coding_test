import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        //1은 2칸 | 0은 4칸 | 나머지는 3칸
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true){
            int sum = 2;
            String a = br.readLine();
            if (a.equals("0")) break;
            String aa[] = a.split("");
            for (int i=0; i<aa.length; i++){
                if (aa[i].equals("1")) sum += 2;
                else if (aa[i].equals("0")) sum += 4;
                else sum += 3;
            }
            sum += aa.length - 1;
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.close();
    }
}