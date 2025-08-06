import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            meeting[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }

        Arrays.sort(meeting, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]); // 종료시간 같으면 시작시간 오름차순
            return Integer.compare(a[1], b[1]); // 종료시간 오름차순
        });

        int count = 0;
        int end = 0;

        for(int i = 0; i < N; i++){
            if(meeting[i][0] >= end){
                end = meeting[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
