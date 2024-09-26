import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int L,R,C;
    static String[][][] map;
    static boolean[][][] visited;
    static int[] start;
    static int[] end;
    static int[][] D = {
    		{-1,0,0},		// 상
    		{1,0,0},		// 하
    		{0,-1,0},		// 북
    		{0,1,0},		// 남
    		{0,0,-1},		// 서
    		{0,0,1},		// 동
    };
    
    public static void main(String[] args) throws Exception{
    	while(true) {
	    	st = new StringTokenizer(br.readLine());
	        L = Integer.parseInt(st.nextToken());
	        R = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        
	        if(L==0 && R==0 && C==0) break;
	        
	        map = new String[L][R][C];
	        visited = new boolean[L][R][C];
	        
	        for(int i=0; i<L; i++) {
	        	for(int j=0; j<R; j++) {
	        		String[] str = br.readLine().split("");
	        		for(int k=0; k<C; k++) {
	        			map[i][j][k] = str[k];
	        			if(map[i][j][k].equals("S")) start = new int[]{i,j,k,0};
	        			if(map[i][j][k].equals("E")) end = new int[]{i,j,k};
	        		}
	        	}
	        	br.readLine();
	        }// 입력 완료
	        
	        // 출력
//	        System.out.println();
//	        for(String[][] e1: map) {
//	        	for(String[] e2: e1) {
//	        		System.out.println(Arrays.toString(e2));
//	        	}
//	        	System.out.println();
//	        }
	        
	        int result = bfs();
	        
	        if(result == 0) System.out.println("Trapped!");
	        else System.out.println("Escaped in " + result + " minute(s).");
    	}
    }
    
    static int bfs() {
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(start);
    	visited[start[0]][start[1]][start[2]] = true;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int z = cur[0];
    		int y = cur[1];
    		int x = cur[2];
    		int dep = cur[3];
    		
    		if(z==end[0] && y==end[1] && x==end[2]) return dep;
    		
    		for(int[] d : D) { // 6방향 탐색
    			int nz = z + d[0];
    			int ny = y + d[1];
    			int nx = x + d[2];
    			
    			if(0 <= nz && nz < L && 0 <= ny && ny < R && 0 <= nx && nx < C && !map[nz][ny][nx].equals("#") && !visited[nz][ny][nx]) {
    				q.add(new int[]{nz,ny,nx,dep+1});
    				visited[nz][ny][nx] = true;
    			}
    		}
    	}
    	return 0;
    }
    
}
