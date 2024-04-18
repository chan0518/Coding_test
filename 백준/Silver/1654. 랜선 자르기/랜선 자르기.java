import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int K = Integer.valueOf(str[0]);
        int N = Integer.valueOf(str[1]);

        long[] arr = new long[K];
        for (int i = 0; i < K; i++) arr[i] = Long.valueOf(br.readLine());//랜선 입력
        Arrays.sort(arr);//랜선 길이별 정렬

        long left = 1;
        long right = arr[arr.length - 1];

        while (left <= right) {
            int sum = 0;//랜선 갯수
            long mid = (left + right) / 2;
            for (int i = 0; i < K; i++) sum += (int)(arr[i] / mid);//mid의 길이로 랜선 갯수 세기

            if (sum < N) right = mid - 1;//랜선갯수가 N보다 작다면 랜선의 크기가 크니까 랜선최대값을 줄여야함
            else left = mid + 1;
        }
        System.out.println(left-1);
    }
}