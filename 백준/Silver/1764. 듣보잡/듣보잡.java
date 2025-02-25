import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M;

    static Set<String> NoListenPerson = new HashSet<>();
    static Set<String> NoLookPerson = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) NoListenPerson.add(br.readLine());
        for (int i = 0; i < M; i++) NoLookPerson.add(br.readLine());

        Set<String> result = NoListenPerson;
        result.retainAll(NoLookPerson);

        System.out.println(result.size());

        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
