import java.util.*;

class Solution{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            // 2를 제외한 모든 짝수를 제거
            while (num % 2 == 0){
                list.add(2);
                num /= 2;
            }

            // 3부터 시작하여 소수만 확인
            for (int i = 3; i * i <= num; i += 2){
                while (num % i == 0) {
                    list.add(i);
                    num /= i;
                }
            }

            if (num > 2) list.add(num);//1이 아니라면 소수

            Set<Integer> set = new HashSet<>(list);
            List<Integer> result_li = new ArrayList<>();
            for (int e1: set){
                int cnt = 0;
                for (int e2: list){
                    if (e1 == e2) cnt ++;
                }
                if (cnt % 2 == 1) result_li.add(e1);
            }

            int result = 1;
            for (int e: result_li) result *= e;
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}
