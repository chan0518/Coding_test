import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 1, -1};
    static int[] dc = {-1, 1, -1, 1};
    static int[][] DP;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        DP = new int[N+1][N+1];
        StringTokenizer st;
        //수익 누적합 구하기
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        //각 꼭짓점 영역 비교하기
        for(int i=1;i<N;i++){
            for(int j=1;j<N;j++){
                //search(i, j, 0, 1) : ↖↘
                //search(i, j, 2, 3) : ↙↗
                cnt += search(i, j, 0, 1) + search(i, j, 2, 3);
            }
        }
        //개수 BufferedWriter 저장
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
    //꼭짓점 기준 영역 탐색하는 함수
    static int search(int y, int x, int d1, int d2){
        int cnt = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        //↖↘영역 탐색
        if(d1 == 0 && d2 == 1){
            compare(y, x, d1, left);
            compare(y+1, x+1, d2, right);
        }else{	//↙↗ 영역 탐색
            compare(y+1, x, d1, left);
            compare(y, x+1, d2, right);
        }

        //수익 같은 경우 구하기
        for(int area : left.keySet()){
            if(right.containsKey(area)){
                cnt += left.get(area) * right.get(area);
            }
        }
        return cnt;
    }
    //각 영역에 존재하는 수익 구하는 함수
    static void compare(int y, int x, int direction, Map<Integer, Integer> map){
        int r = y;
        while(r > 0 && r <= N ){
            int temp;
            int c = x;
            while(c > 0 && c <= N){
                if(direction == 0) {	//↖ 영역 수익 구하기
                    temp = calArea(r, c, y, x);
                } else if(direction == 1) {	//↘ 영역 수익 구하기
                    temp = calArea(y, x, r, c);
                } else if(direction == 2) {	//↙ 영역 수익 구하기
                    temp = calArea(y, c, r, x);
                } else {	//↗ 영역 수익 구하기
                    temp = calArea(r, x, y, c);
                }
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                c += dc[direction];	//x축 이동
            }
            r += dr[direction];		//y축 이동
        }
    }
    //영역 수익 구하는 함수
    static int calArea(int r1, int c1, int r2, int c2){
        return DP[r2][c2] - DP[r1-1][c2] - DP[r2][c1-1] + DP[r1-1][c1-1];
    }
}