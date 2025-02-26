import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;
    static HashMap<String, String> poketmon = new HashMap();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            poketmon.put(i+"", str);
            poketmon.put(str, i+"");
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            System.out.println(poketmon.get(value));
        }

    }
}
