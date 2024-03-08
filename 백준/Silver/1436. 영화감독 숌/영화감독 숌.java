import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int cnt = 0;

        int num = 665;
        while (true){
            String a = String.valueOf(num);
            if (a.indexOf("666") != -1){
                cnt++;
                if (cnt == N) break;
            }
            num++;
        }
        System.out.println(num);
        
        br.close();
        bw.close();
    }
}
