import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        Set<String> A = new HashSet<>();
        Set<String> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A.add(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) B.add(st.nextToken());

        int result = A.size() + B.size();

        A.retainAll(B);
        result -= A.size() * 2;

        System.out.println(result);
    }
}
