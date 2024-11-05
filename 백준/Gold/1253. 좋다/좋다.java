import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(cal());
    }

    static int cal() {
    	int cnt = 0;
    	for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            int num = arr[i];
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum < num) left++;
                else if (sum > num) right--;
                else {
                    if (i != left && i != right) { // 두 수의 인덱스가 i가 아니라면
                        cnt++;
                        break;
                    }
                    if (left == i) left++;
                    if (right == i) right--;
                }
            }
        }
    	return cnt;
    }
}
