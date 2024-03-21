import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Double> map = new TreeMap<>();

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        double sum = 0.0;
        int grade = 0;
        for (int i=0; i<20; i++){
            String[] str = br.readLine().split(" ");
            if (str[2].equals("P")) continue;
            sum += Double.valueOf(str[1]) * map.get(str[2]);
            grade += Double.valueOf(str[1]);
        }

        double result = sum == 0.0 ? 0.0 : sum/grade;
        bw.write(String.format("%.6f", result));
        br.close();
        bw.close();
    }
}