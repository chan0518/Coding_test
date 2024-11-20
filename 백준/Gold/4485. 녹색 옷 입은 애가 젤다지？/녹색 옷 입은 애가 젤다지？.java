import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map, memo;
	static int[][] DIRECTION = {
			{-1,0},		// 상
			{1,0},		// 하
			{0,-1},		// 좌
			{0,1}		// 우
	};
	static int result, N, T=1;
	
	public static void main(String[] args) throws IOException {
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) {
				System.out.println(sb.toString());;
				return;
			};
			
			sb.append("Problem ").append(T++).append(": ");
			result = 0;
			map = new int[N][N];
			memo = new int[N][N];
//			for(int[] e : memo) Arrays.fill(e, Integer.MAX_VALUE);
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// 입력완료
			bfs();
			sb.append(result).append("\n");
		}
		
	}
	
	static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,map[0][0])); // x, y, w		w는 가중치
		memo[0][0] = 1; // 방문함
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int x = cur.x;
			int y = cur.y;
			int w = cur.w;
			
			if(x == N-1 && y == N-1) result = w;
			
			for(int i=0; i<4; i++) {
				int nx = x + DIRECTION[i][0];
				int ny = y + DIRECTION[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(memo[nx][ny] == 1) continue;
				
				memo[nx][ny] = 1;
				pq.add(new Node(nx,ny, w + map[nx][ny])); // 현재까지의 가중치합 + 다음 가중치
			}
			
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}
	}
}