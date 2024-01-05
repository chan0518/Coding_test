import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input1 = in.nextLine().split(" ");
        int K = Integer.valueOf(input1[0]);
        int N = Integer.valueOf(input1[1]);
        int[] arr = new int[K];
        long max = 0;
        // 입력과 동시에 해당 랜선의 길이가 최댓값인지를 확인하고 max를 갱신
        for (int i = 0; i < K; i++) {
            arr[i] = in.nextInt();
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        long min = 0; // 탐색 길이 최솟값
        long mid = 0;
        
        while (min < max) {
            mid = (max + min) / 2;
            
            long count = 0;

            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            if(count < N) max = mid;
            else min = mid + 1;
        }
        // UpperBound로 얻어진 값(min)에 -1이 최대 길이가 된다.
        System.out.println(min - 1);
    }
}