import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        String[] str = br.readLine().split(" ");
        Integer[] arr = new Integer[N];
        for (int i = 0; i < str.length; i++) arr[i] = Integer.valueOf(str[i]);
        Integer[] sort_arr = arr.clone();
        Arrays.sort(sort_arr);//arr 정렬

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(sort_arr[0], 0);
        int value = sort_arr[0];
        int idx = 0;
        for (int i = 1; i < N; i++) {//HashMap에 값 입력
            if (sort_arr[i] != value) {
                value = sort_arr[i];
                hm.put(value, ++idx);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int e: arr) sb.append(hm.get(e)).append(" ");
        System.out.println(sb);
    }
}