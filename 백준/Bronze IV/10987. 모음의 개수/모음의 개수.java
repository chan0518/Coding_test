import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //(a, e, i, o, u)
        String a[] = br.readLine().split("");

        int cnt=0;
        for (int i=0; i<a.length; i++){
            if (a[i].equals("a") || a[i].equals("e") || a[i].equals("i") || a[i].equals("o") || a[i].equals("u")){
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}