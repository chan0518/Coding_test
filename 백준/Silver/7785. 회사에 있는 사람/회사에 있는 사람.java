import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        HashMap<String, String> hm = new HashMap<>();

        for (int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            if (hm.containsKey(str[0])) hm.remove(str[0]);
            else hm.put(str[0], str[1]);
        }
        ArrayList<String> li = new ArrayList<>(hm.keySet());
        Collections.sort(li, Collections.reverseOrder());
        for (String e: li) System.out.println(e);
    }
}
