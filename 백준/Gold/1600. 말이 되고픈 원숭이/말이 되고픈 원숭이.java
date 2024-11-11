import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] D = {
			{-1, 0},	// 상
			{1, 0},		// 하
			{0, -1},	// 좌
			{0, 1},		// 우
	};
	
	static int[][] Horse = {
			{-1,-2},
			{-2,-1},
			{-2, 1},
			{-1, 2},
			{1, 2},
			{2, 1},
			{2, -1},
			{1, -2},
	};
	
	
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}// 입력완료
		
//		printMap();
		
		int result = bfs();
		System.out.println(result);
		
	}
	

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,0, K,0});
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			int dep = cur[3];
			
			if(x == H-1 && y == W-1) return dep;
			
			// 1.상		2.하		3.좌		4.우		5.말
			for(int i=0; i<4; i++) { // 원숭이 상 하 좌 우
				int nx = x + D[i][0];
				int ny = y + D[i][1];
				
				if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				if(visited[nx][ny][k]) continue;
				if(map[nx][ny] == 1) continue;
				
				visited[nx][ny][k] = true;
				q.add(new int[] {nx,ny,k,dep+1});
			}
			if(k > 0) { // 말 이동 8가지
				for(int i=0; i<8; i++) {
					int nx = x + Horse[i][0];
					int ny = y + Horse[i][1];
					
					if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if(visited[nx][ny][k-1]) continue;
					if(map[nx][ny] == 1) continue;

					visited[nx][ny][k-1] = true;
					q.add(new int[] {nx,ny,k-1,dep+1});
				}
			}
		}
		return -1;
	}
	
	static void printMap() {
		for(int[] e : map) System.out.println(Arrays.toString(e));
	}
	
}