import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] range_arr = new int[8001];
        ArrayList<Integer> li = new ArrayList<>();
        int sum = 0;//합

        for (int i=0; i<N; i++){
            int num = Integer.valueOf(br.readLine());
            li.add(num);
            sum += num;
            if (num < 0) num = num*-1 + 4000;
            range_arr[num]++;//최다빈도
        }
        int max = 0;
        for (int e: range_arr) if (max < e) max = e;//최빈값 찾기
        boolean TF = false;
        ArrayList<Integer> range_li = new ArrayList<>();
        for (int i=0; i<range_arr.length; i++) if (range_arr[i] == max) range_li.add(i > 4000 ? (i-4000)*-1:i);
        Collections.sort(range_li);

        int avg = (int) Math.round((double)sum/ (double)N);
        Collections.sort(li);
        System.out.println(avg);
        System.out.println(li.get(li.size()/2));
        System.out.println(range_li.size() == 1 ? range_li.get(0):range_li.get(1));
        System.out.println(li.get(li.size()-1) - li.get(0));//범위
    }
}
