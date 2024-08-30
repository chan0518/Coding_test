import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n,m,result;
	static int[][] map;
	static boolean[][] visited;
	static int[][] D = {
			{-1,0},		// 상
			{1,0},		// 하
			{0,-1},		// 좌
			{0,1},		// 우
	};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
        	String str = br.readLine();
        	for(int j=0; j<m; j++) {
        		map[i][j] = str.charAt(j) - '0';
        	}
        }
        bfs(1);
        System.out.println(result);
    }
    
    static void bfs(int depth) {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {0,0,depth}); // (x,y) depth = 1
    	visited[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		int[] current = q.poll();
    		int x = current[0];
    		int y = current[1];
    		int dep = current[2];
    		
    		if(x == n-1 && y == m-1) {
    			result = dep;
    			return;
    		}
    		
    		for(int[] d : D) {
    			int nx = x + d[0];
    			int ny = y + d[1];
    			
    			if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
    				q.add(new int[] {nx,ny,dep+1});
    				visited[nx][ny] = true;
    			}
    		}
    	}
    }
}