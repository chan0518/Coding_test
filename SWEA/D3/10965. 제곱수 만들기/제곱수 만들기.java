
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            //여기 사이에 코드를 넣을 것

            int num = Integer.valueOf(br.readLine());
            List<Integer> list = new ArrayList<>();
            while (num % 2 == 0) {
                list.add(2);
                num /= 2;
            }//num의 2의 약수만 구함

            for (int i = 3; i * i <= num; i += 2) {
                while (num % i == 0) {
                    list.add(i);
                    num /= i;
                }
            }

            if (num > 2) list.add(num);//1이 아니라면 소수

            Set<Integer> set = new HashSet<>(list);
            List<Integer> result_li = new ArrayList<>();
            for (int e1 : set) {
                int cnt = 0;
                for (int e2 : list) {
                    if (e1 == e2) cnt++;
                }
                if (cnt % 2 == 1) result_li.add(e1);
            }

            int result = 1;
            for (int e : result_li) result *= e;
            System.out.printf("#%d %d\n", test_case, result);

            //여기사이에 코드를 넣을 것
        }
    }
}