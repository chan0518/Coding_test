import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] visited;
	static boolean[][] finished;
	static int safezone;
	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				int c = line.charAt(j);
				if(c == 'U') map[i][j] = 0;
				else if(c == 'D') map[i][j] = 1;
				else if(c == 'L') map[i][j] = 2;
				else if(c == 'R') map[i][j] = 3;
			}
		}
		
		
		// 사이클의 개수를 세면 된다.
		visited = new boolean[N][M]; // 방문한 위치
		finished = new boolean[N][M]; // 사이클인지 확인한 위치
		safezone = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]) dfs(i,j);
			}
		}
		
		System.out.println(safezone);
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void dfs(int r, int c) {
		
		visited[r][c] = true;
		
		int nr = r + dr[map[r][c]];
		int nc = c + dc[map[r][c]];
		
		if(!visited[nr][nc]) {
			dfs(nr,nc);
		}else {
			
			if(!finished[nr][nc]) safezone++;
		}
		
		finished[r][c] = true;
	}

}