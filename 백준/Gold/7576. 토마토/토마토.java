import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<int[]> li = new ArrayList<>();
    static int[][] D = {
    		{-1,0},		// 상
    		{1,0},		// 하
    		{0,-1},		// 좌
    		{0,1},		// 우
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<M; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        		if(map[i][j] == 1) li.add(new int[] {i,j,0});
        	}
        }
        
//        for(int[] e : map) System.out.println(Arrays.toString(e));
        
        int result = bfs();
        
        for(int[] e1 : map) {
        	for(int e2 : e1) {
        		if(e2 == 0) {
        			System.out.println(-1);
        			return;
        		}
        	}
        }
        System.out.println(result);
    }
    
    static int bfs() {
    	Queue<int[]> q = new ArrayDeque<>();
    	for(int[] e : li) q.add(e);
    	int depth = 0;
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int x = cur[0];
    		int y = cur[1];
    		int dep = cur[2];
    		
    		for(int[] d : D) {
    			int nx = x + d[0];
    			int ny = y + d[1];
    			
    			if(0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {// 익지 않은 토마토만 접근
    				map[nx][ny] = 1;
    				q.add(new int[] {nx,ny,dep+1});
    			}
    			
    		}
    		depth = dep;// 가장 나중에 방문한 곳에 depth가 가장 크므로 계속 초기화 시켜줌;
    	}
    	return depth;
    }
    
}