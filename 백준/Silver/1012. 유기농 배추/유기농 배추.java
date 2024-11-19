import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int M, N, K, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] D = {
			{-1, 0},	// 상
			{1, 0},		// 하
			{0, -1},	// 좌
			{0, 1},		// 우
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) cal();
		System.out.println(sb.toString());
	}
	
	static void cal() throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		
//		System.out.println();
//		for(int[] e : map) System.out.println(Arrays.toString(e));
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) bfs(i,j);
			}
		}
		sb.append(cnt).append("\n");
	}
	
	static void bfs(int a, int b) {
		if(visited[a][b]) return;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{a,b});
		visited[a][b] = true;
		cnt++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0; i<4; i++) {
				int nx = x + D[i][0];
				int ny = y + D[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(visited[nx][ny]) continue;
				if(map[nx][ny] != 1) continue;
				
				visited[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
		}
		
	}
	
}
