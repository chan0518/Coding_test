import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str[] = br.readLine().split("");
        int cnt = 0;
        for (int i=0; i<str.length; i++){
            if (i <str.length-1) {
                if (str[i].equals("c")) {
                    if (str[i + 1].equals("=")) {
                        i++;
                        cnt++;
                        continue;
                    } else if (str[i + 1].equals("-")) {
                        i++;
                        cnt++;
                        continue;
                    }
                }
                if (str[i].equals("d")) {
                    if (str[i + 1].equals("z") && (i+2) < str.length) {
                        if (str[i + 2].equals("=")) {
                            i += 2;
                            cnt++;
                            continue;
                        }
                    } else if (str[i + 1].equals("-")) {
                        i++;
                        cnt++;
                        continue;
                    }
                }
                if (str[i].equals("l") || str[i].equals("n")) {
                    if (str[i + 1].equals("j")) {
                        i++;
                        cnt++;
                        continue;
                    }
                }
                if (str[i].equals("s") || str[i].equals("z")) {
                    if (str[i + 1].equals("=")) {
                        i++;
                        cnt++;
                        continue;
                    }
                }
            }
            cnt++;
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
