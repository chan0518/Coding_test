import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			solution();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, result;
	static int[][] map, memo;
	static int[][] D = {
			{-1,0},
			{1,0},
			{0,-1},
			{0,1},
	};
	
	static void solution() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		memo = new int[N][N];
		for(int i=0; i<N; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}// 입력완료
		
//		for(int[] e : map) System.out.println(Arrays.toString(e));
		bfs();
//		for(int[] e : memo) System.out.println(Arrays.toString(e));
		sb.append(result);
	}
	
	static void bfs() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0,0,0)); // x, y, 시간
		memo[0][0] = 0;
		result = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int w = cur.w;
			
			if(x == N-1 && y == N-1) result = w;
			
			for(int i=0; i<4; i++) {
				int nx = x + D[i][0];
				int ny = y + D[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(memo[nx][ny] != Integer.MAX_VALUE) continue; // 방문했다면 방문안함
				memo[nx][ny] = w + map[nx][ny];
				q.add(new Node(nx,ny,w + map[nx][ny]));
			}
		}
	}
}
class Node implements Comparable<Node> {
    int x;
    int y;
    int w;
 
    Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
 
    @Override
    public int compareTo(Node o) {
        return w - o.w;
    }
}