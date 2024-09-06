import java.util.*;
import java.io.*;
 
public class Solution {
    static int N, M, K;
    static int Hcnt, Kmoney, Hmoney; // Hcnt = 서비스를 제공받는 집들의 수, Kmoney = 운영비용, Hmoney = 집 수익
    static int[][] map;
    static boolean[][] visited;
    static int[][] D = {
    		{-1, 0},	// 상
    		{1, 0},		// 하
    		{0, -1},	// 좌
    		{0, 1}, 	// 우
    };
    
    public static void main(String[] args) throws Exception {
//    	System.setIn(new FileInputStream("src/input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
 
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // N = 크기
            M = Integer.parseInt(st.nextToken()); // M = 집마다의 비용
            map = new int[N][N]; // 맵
            Kmoney = Hmoney = Hcnt = 0;
            
            for(int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }// map 입력 완료
            
            // map 출력
//            System.out.println("N=" + N + ", M=" + M);
//            for(int[] e : map) System.out.println(Arrays.toString(e));
            
            K = N+1;
            
            for(int i=K; i>=1; i--) {
            	Kmoney = i*i + (i-1)*(i-1);
            	if(isRevenue(i)) break;
            }
            
            sb.append(Hcnt).append('\n');
        }
        System.out.println(sb.toString());
    }
    
    static int bfs(int sx, int sy, int depth) {
    	int cnt = 0;
    	visited = new boolean[N][N];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {sx,sy, 1});
    	visited[sx][sy] = true;
    	if(map[sx][sy] == 1) ++cnt;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int x = cur[0];
    		int y = cur[1];
    		int dep = cur[2];
    		
    		if(dep >= depth) return cnt;
    		
    		for(int[] d : D) {
    			int nx = x + d[0];
    			int ny = y + d[1];
    			
    			if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
    				q.add(new int[] {nx,ny,dep+1});
    				visited[nx][ny] = true;
    				if(map[nx][ny] == 1) ++cnt;
    			}
    		}
    	}
    	return cnt;
    }
    
    static boolean isRevenue(int depth) {// depth의 범위에 방범을 돌아서 수익이라면 true 리턴
    	boolean flag = false;
    	for(int i=0; i<N; i++) {
        	for (int j = 0; j < N; j++) {
        		int cnt = bfs(i,j,depth);
        		if((cnt*M - Kmoney) >= 0) {
        			Hcnt = Math.max(Hcnt, cnt);
        			flag = true;
        		}
        	}
        }
    	return flag;
    }
    
    
}