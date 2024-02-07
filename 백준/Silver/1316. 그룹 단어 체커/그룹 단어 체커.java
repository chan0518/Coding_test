import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int cnt = 0;

        mainLoop:
        for (int i=0; i<N; i++){
            String a[] = br.readLine().split("");

            if (a.length < 3) cnt++;
            else{
                for (int k=0; k<a.length-2; k++){//3
                    for (int j=k+2; j<a.length; j++){
                        if (a[k].equals(a[k+1])) {}
                        else {
                            if (a[k].equals(a[j])) {
                                continue mainLoop;
                            }
                        }
                    }
                }
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
