import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static ArrayList<int[]> mineXY;
	static boolean[][] visited;
	static int N, cnt;
	static char[][] map;
	static int[][] D = {
			{-1,0},		// 상 
			{1,0},		// 하
			{0,-1},		// 좌
			{0, 1},		// 우
			{-1,-1},	// 상좌
			{-1, 1},	// 상우
			{1, -1},	// 하좌
			{1,1},		// 하우
	};
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			mineXY = new ArrayList<>();
			visited = new boolean[N][N];
			cnt = 0;
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') mineXY.add(new int[] {i,j});// 지뢰 좌표 저장
				}
			}// 입력 완료
			
//			info();
			mineNum();// 지뢰주변칸을 1로 만듦
//			info();
			blankCal();// 주변에 지뢰가 없는 칸들을 bfs로 확장
//			info();
			numCal();
//			info();
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void blankCal() {// 빈칸확장
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '.') {
					++cnt;
					bfs(i, j);
				}
			}
		}
	}
	
	static void numCal() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == '1') ++cnt;
			}
		}
	}
	
	static void mineNum() {// 지뢰주변에 지뢰갯수를 세어줌
		boolean[][] visited = new boolean[N][N];
		for(int[] e : mineXY) {
			for(int[] d : D) {
				int ni = e[0] + d[0];
				int nj = e[1] + d[1];
				
				if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj] && map[ni][nj] != '*') {
					visited[ni][nj] = true;
					if(map[ni][nj] == '.') map[ni][nj] = '1';
				}
			}
		}
	}
	
	static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy});
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			map[x][y] = 'x';
			
			for(int[] d : D) {
				int nx = x + d[0];
				int ny = y + d[1];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != '*' && !visited[nx][ny] && map[nx][ny] != 'x') {
					if (map[nx][ny] == '.') {
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
					}
					else map[nx][ny] = 'x';
				}
			}
		}
	}
	
//	// 출력 함수 *제출시 삭제
//	static void info() {
//		System.out.println("=====info=====\t" + "cnt: " + cnt);
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) System.out.print(map[i][j]+" ");
//			System.out.println();
//		}
//	}
}
