import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ten = br.readLine().split("");

        String[] two = {"000", "001", "010", "011", "100", "101", "110", "111",};
        StringBuilder sb = new StringBuilder();

        sb.append(Integer.valueOf(two[Integer.valueOf(ten[0])]));
        for (int i = 1; i < ten.length; i++) {
            sb.append(two[Integer.valueOf(ten[i])]);
        }
        System.out.println(sb);
    }
}