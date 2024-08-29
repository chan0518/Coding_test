import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int N, sx, sy;
	static int[][] map;
	static boolean[] dup;
	static ArrayList<Integer> li;
	static int max;
	static final int[][] D = {
			{1,1},		// 오밑
			{1,-1},		// 왼밑
			{-1,-1},	// 왼위
			{-1,1},		// 오위
	};
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = -1;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력 완료
			
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					sx = i; sy = j;
					dup = new boolean[101]; // 0~100
					dup[map[i][j]] = true;
					dfs(i,j, 1, 0);
				}
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(max+"\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int x, int y, int depth, int direction) {
		for(int i=direction; i<=direction+1 && i <= 3; i++) {
			int nx = x + D[i][0];
			int ny = y + D[i][1];
			
			if(sx == nx && sy == ny) {
				max = Math.max(max, depth);
				return;
			}
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N && !dup[map[nx][ny]]) {// nx,ny가 map범위 안에 있고 map[nx][ny]의 값이 li안에 없다면
				dup[map[nx][ny]] = true;
				dfs(nx,ny, depth+1, i);
				dup[map[nx][ny]] = false;
			}
		}
	}
}