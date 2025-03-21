import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static int[] budget;
    static int total_budget;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        budget = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
            min = Math.min(min, budget[i]);
        }

        st = new StringTokenizer(br.readLine());
        total_budget = Integer.parseInt(st.nextToken());

        int result = Binary_Search();
        System.out.println(result);
    }


    public static int Binary_Search(){
        int left = 0;
        int right = max;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int num = Cal(mid);

            if(num > total_budget) {
                right = mid - 1;
            }
            else if(num < total_budget) {
                left = mid + 1;
                ans = mid;
            }
            else if(num == total_budget) {
                ans = mid;
                break;
            }
        }
        return ans;
    }

    public static int Cal(int mid){
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(budget[i] < mid) sum += budget[i];
            else sum += mid;
        }
        return sum;
    }


}
