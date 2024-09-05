import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, result;
	static int[][] map, dp;
	static int[][] D = {
			{1, 0},		// 하
			{1,1},		// 우하
			{0,1},		// 우
	};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		result = 0;
		
		for(int i=0; i<N; i++) for(int j=0; j<M; j++) dp[i][j] = -1;// dp 초기화
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력 완료
		result = dpDFS(0, 0);
//		dfs(0, 0, map[0][0]);
		System.out.println(result);
	}
	
	static int dpDFS(int x, int y) {
		if(x == N-1 && y == M-1) {
			return map[x][y];
		}
		
		if(dp[x][y] != -1) return dp[x][y];
		else {
			for(int[] d : D) {
				int nx = x + d[0];
				int ny = y + d[1];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M) {
					dp[x][y] = Math.max(dp[x][y], map[x][y] + dpDFS(nx, ny));
				}
			}
			return dp[x][y];
		}
	}
	
	
	static void dfs(int x, int y, int sum) {
		if(x == N-1 && y == M-1) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int[] d : D) {
			int nx = x + d[0];
			int ny = y + d[1];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				dfs(nx,ny, sum+map[nx][ny]);
			}
		}
	}
	
	
	
}
