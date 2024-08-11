import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[][] map ;
	static int N;
	static int cnt = 0;
	static int cntRG = 0;
	static boolean[][] visited;
	static boolean[][] visitedRG;
	static Queue<int[]> q = new LinkedList();
	static final int[][] DIRECTION = {
			{-1,0},//위
			{1,0},//아래
			{0,-1},//왼쪽
			{0,1},//오른쪽
	};
	
	public static void bfs(int startX, int startY) {
		String type = map[startX][startY];
		
		//시작노드를 큐에 추가하고 방문 처리
		q.offer(new int[] {startX,startY});
		visited[startX][startY] = true;
		++cnt;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			
			//인접 노드 탐색
			for(int[] d : DIRECTION) {//4번 반복
				int nx = x+d[0];
				int ny = y+d[1];
				
				//배열의 범위를 벗어나지 않고 방문하지 않은 노드인지 확인
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && type.equals(map[nx][ny])) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static void bfsRG(int startX, int startY) {
		String type = map[startX][startY];
		
		//시작노드를 큐에 추가하고 방문 처리
		q.offer(new int[] {startX,startY});
		visitedRG[startX][startY] = true;
		++cntRG;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];

			//인접 노드 탐색
			for(int[] d : DIRECTION) {//4번 반복
				int nx = x+d[0];
				int ny = y+d[1];
				
				//배열의 범위를 벗어나지 않고 방문하지 않은 노드인지 확인
				if(0 <= nx && nx < N && 0 <= ny && ny < N && !visitedRG[nx][ny]) {
					if(type.equals("R") || type.equals("G")) {
						if(map[nx][ny].equals("R") || map[nx][ny].equals("G")) {
							visitedRG[nx][ny] = true;
							q.offer(new int[] {nx,ny});
						}
					}
					else if(type.equals("B") && map[nx][ny].equals("B")) {
						visitedRG[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
//		info(visitedRG);
	}
	
//	static void info(boolean[][] visited) {
//		for(boolean[] e1: visited) {
//			for(boolean e2: e1) {
//				System.out.print(e2+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void info(String[][] map) {
//		for(String[] e1: map) {
//			for(String e2: e1) {
//				System.out.print(e2+"\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		visitedRG = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String[] input = br.readLine().split("");
			map[i] = input.clone();
		}//rgb입력 완료
		
//		info(map);
//		info(visitedRG);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) bfs(i,j);
				if(!visitedRG[i][j]) bfsRG(i,j);
			}
		}
		System.out.println(cnt+" "+cntRG);
	}
}