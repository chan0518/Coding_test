import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static int cheese = 0;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[][] DIRECTION = {
			{-1, 0},//상
			{1, 0},//하
			{0, 1},//좌
			{0, -1},//우
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		while(!isZero()) {
			bfs(0,0);
			two_zero();
			if(!existOne()) {
				System.out.println(cnt);
				System.out.println(cheese);
				return;
			}
		}
		
	}
	public static boolean existOne() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) if(map[i][j] == 1) return true;
		}
		return false;
	}
	public static void two_zero() {
		cheese = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0;
					++cheese;
				}
			}
		}
	}
	public static boolean isZero() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) if(map[i][j] != 0) return false;
		}
		return true;
	}
	
	public static void bfs(int startX, int startY) {
		int type = map[startX][startY];
		++cnt;
		
		q.offer(new int[] {startX, startY});
		visited = new boolean[N][M]; 
		visited[startX][startY] = true;;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			for(int[] d: DIRECTION) {
				int nx = x+d[0];
				int ny = y+d[1];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && map[x][y]==0) {
					if(map[nx][ny] == 1) map[nx][ny] = 2;
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}

//	static void info(int[][] map) {
//		for(int[] e1: map) {
//			for(int e2: e1) {
//				System.out.print(e2+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void info(boolean[][] visited) {
//		for(boolean[] e1: visited) {
//			for(boolean e2: e1) {
//				System.out.print(e2+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}