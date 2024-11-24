import java.io.*;
import java.util.*;

public class Main {
	static int N, K, T;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());// 수빈 위치
        K = Integer.parseInt(st.nextToken());// 동생 위치
        T = 0;
        bfs(N);
        System.out.println(T);
    }    
    
    static int dfs(int time) {
    	if(N == K) return 0;
    	
    	return time;
    }
    
    static void bfs(int start) {
    	boolean[] visited = new boolean[100001];
    	Queue<int[]> q = new ArrayDeque<>();
    	q.add(new int[] {start, 0});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int num = cur[0];
    		int time = cur[1];
//    		System.out.println("num: " + num + ", time: " + time);
    		
    		if(num < 0) continue;
    		if(num > 100000) continue;
    		if(visited[num]) continue;// 방문했던 곳이면 리턴
    		visited[num] = true;
    		
    		if(num == K) {
    			T = time;
    			return;
    		}
    		
    		q.add(new int[] {num-1, time+1});
    		q.add(new int[] {num+1, time+1});
    		q.add(new int[] {num*2, time+1});
    	}
    }
}
