import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int cnt = 0;
	static int[][] map;
	static BufferedReader br;
	static StringTokenizer st;
	static int[][] D = {
			{1, 0}, // 아래
			{1, 1}, // 오른쪽 아래
			{0, 1}, // 오른쪽
	};
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력완료
//		mapInfo();
		bfs(new int[] {0,1,2});//{x, y, state} 0,1의 좌표에 D[2]방향을 보고있음
		System.out.println(cnt);
	}
	
	static void bfs(int[] xy) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.push(xy);
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int state = current[2];//파이프가 바라보고 있는 방향
			
			if(x == N-1 && y == N-1) {
				++cnt;
				continue;
			}
			
			LoopD:
			for(int i=0; i<3; i++) {
				if(state == 0 && i == 2 || state == 2 && i == 0) continue;
				//파이프방향이 아래를 보고 있다면 오른쪽 패스,오른쪽을 보고 있다면 아래를 패스
				
				if(i == 1) {//대각선을 갈수 있나 확인하기전에 주변에 1이 있나 없나 확인
					for(int[] d : D) {
						int dx = x + d[0];
						int dy = y + d[1];
						if(0 <= dx && dx < N && 0 <= dy && dy < N && map[dx][dy] == 1) continue LoopD;
					}//대각선으로 갈 때 주변에 1이 있다면 LoopD를 continue함
				}
				
				int nx = x + D[i][0];
				int ny = y + D[i][1];
				
				if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] != 1) {//map의 범위안에 있다면
					q.push(new int[] {nx, ny, i});//탐색 가능한 좌표와 현재 파이프 방향값을 넣어줌
				}
			}
		}
	}
	
//	static void mapInfo(){
//		for(int[] e1: map) {
//			for(int e2: e1) System.out.print(e2+" ");
//			System.out.println();
//		}
//	}
	
}
