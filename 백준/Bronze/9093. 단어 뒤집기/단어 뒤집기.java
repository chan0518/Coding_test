import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        for (int i=0; i<N; i++) {
            StringBuilder sb = new StringBuilder();
            String st = br.readLine();
            for (int j=0; j< st.length(); j++) sb.append(st.charAt(st.length()-1-j));//거꾸로 담음
            st = sb.toString();
            String[] str = st.split(" ");
            sb.delete(0, sb.length());
            for (int j=0; j<str.length; j++) sb.append(str[str.length-1-j]).append(" ");
            System.out.println(sb);
        }
    }
}