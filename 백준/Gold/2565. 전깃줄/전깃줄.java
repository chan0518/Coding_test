import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	static int[][] line;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int max = 0;
        dp = new int[num];
        line = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }// 입력 완료

        Arrays.sort(line, Comparator.comparingInt(i -> i[0])); // 시작점 기준으로 정렬

        for (int i = 0; i < num; i++) {
            max = Math.max(max, cal(i));
        }
        System.out.println(num-max);
//        System.out.println(Arrays.toString(dp));
    }

    static int cal(int a){
        if(dp[a] == 0){
            dp[a] = 1;
            for (int i = a+1; i < dp.length; i++) {
                if(line[a][1] < line[i][1]){ // 설치가 가능하다면
                    dp[a] = Math.max(dp[a],cal(i)+1);
                }
            }
        }
        return dp[a];
    }
}
