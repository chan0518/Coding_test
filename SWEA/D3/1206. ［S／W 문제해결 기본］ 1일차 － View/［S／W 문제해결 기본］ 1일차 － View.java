
import java.util.*;
import java.io.FileInputStream;

class Solution{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            //여기 사이에 코드를 넣을 것
            int sum = 0;
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i=0; i<N; i++) arr[i] = sc.nextInt();
            //입력 끝
            for (int i=2; i<N-2; i++){
                int max = Math.max(arr[i - 2], Math.max(arr[i - 1], Math.max(arr[i + 1], arr[i + 2])));
                if (arr[i] > max) sum += arr[i] - max;//만약 현재인덱스 건물이 max건물보다 크다면 조망권집의 개수 추가
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#"+ tc + " ");
            sb.append(sum);
            System.out.println(sb);


            //여기사이에 코드를 넣을 것
        }
    }
}