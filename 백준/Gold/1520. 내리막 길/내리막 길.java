import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] memo;
	static int[][] D = {
			{-1, 0},	// 상
			{1, 0},		// 하
			{0, -1},	// 좌
			{0, 1},		// 우
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		memo = new int[N][M];
		
		for(int i=0; i<N; i++) Arrays.fill(memo[i], -1);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력완료
		
//		for(int[] e : map) System.out.println(Arrays.toString(e));
		dfs(0,0);
//		for(int[] e : memo) System.out.println(Arrays.toString(e));

		System.out.println(memo[0][0]);
	}
	
	static int dfs(int x, int y) {
		if(memo[x][y] != -1) return memo[x][y]; // 이미 계산된 값이라면
		if(x == N-1 && y == M-1) return 1;
		memo[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x + D[i][0];
			int ny = y + D[i][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 범위 벗어나면
			if(map[x][y] <= map[nx][ny]) continue; // 다음값이 작지 않다면
			
			memo[x][y] += dfs(nx,ny);
		}
		return memo[x][y];
	}
	
	
}
