import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution {
    static StringBuilder sb = new StringBuilder();
    static int T, N;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int[][] D = {
    		{-1, 0},	// 상
    		{1, 0},		// 하
    		{0, -1},	// 좌
    		{0, 1},		// 우
    };
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        T = Integer.valueOf(br.readLine());
        // T 입력 받음
         
        for (int tc = 1; tc <= T; tc++) {
        	sb.append("#").append(tc).append(" ");
        	//////////////////////////////////////////////////////////////////////////////////
        	N = Integer.parseInt(br.readLine());
        	result = 0;
        	
            map = new int[N][N];
            visited = new boolean[N][N];
            
            for(int i=0; i<N; i++) {
            	char[] st = br.readLine().toCharArray();
            	for(int j=0; j<N; j++) map[i][j] = st[j] - '0';
            }
            
            if(N==1) result = map[0][0];
            else bfs(0);
            
            
            //////////////////////////////////////////////////////////////////////////////////
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    static void bfs(int num) {
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {N/2,N/2,num}); // (x, y)와 뎁스 0을 넘겨줌
    	visited[N/2][N/2] = true;//정중앙은 탐색 했으니 true;
    	
    	while(!q.isEmpty()) {
    		int[] current = q.poll();
    		int x = current[0];// 현재 x값
    		int y = current[1];// 현재 y값
    		int depth = current[2]; // 현재 뎁스
    		result += map[x][y];
    		
    		for(int[] d : D) {
    			int nx = x + d[0]; // 탐색 할 x값
    			int ny = y + d[1]; // 탐색 할 y값
    			int nd = depth+1;
    			
    			if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny] && nd <= N/2) {
    				// 탐색할 x,y 값인 nx,ny가 map범위 안에 있고 방문을 안했고 탐색 할 위치의 뎁스가 N/2 이하라면
    				q.add(new int[] {nx,ny, nd});
    				visited[nx][ny] = true;
    			}
    		}
    	}
    }
}