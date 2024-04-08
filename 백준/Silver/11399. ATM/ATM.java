import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] arr = new int[str.length];
        for (int i=0; i<str.length; i++) arr[i] = Integer.valueOf(str[i]);
        Arrays.sort(arr);
        ArrayList<Integer> li = new ArrayList<>();
        for (int i=0; i<str.length; i++) li.add(arr[i]);
        for (int i=1; i<str.length; i++){
            int sum = 0;
            for (int j=0; j<i; j++) sum += arr[j];
            li.set(i, li.get(i)+sum);
        }
        int result = 0;
        for (int e: li) result += e;
        System.out.println(result);
    }
}