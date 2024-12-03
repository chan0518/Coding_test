import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			S();
			sb.append(result);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int result, N, M;
	static boolean[] visited;
	static HashMap<Integer, List<Integer>> hm;
	
	static void S() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		hm = new HashMap<>();
		for(int i=1; i<=N; i++) hm.put(i, new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			hm.get(a).add(b);// a -> b
			hm.get(b).add(a);// b -> a
		}// 입력완료
		
		bfs();
		result = 0;
		for(int i=2; i<=N; i++) {
			if(visited[i]) {
				result++;
			}
		}
	}
	
	
	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {1,1});
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int depth = cur[1];
			List<Integer> li = hm.get(node);
			
			for(int e : li) {
				if(depth >= 3) break;
				if(visited[e]) continue;
				visited[e] = true;
				q.add(new int[] {e, depth+1});
			}
		}
	}
	
}


/*


2
6 5
2 3
3 4
4 5
5 6
2 5
6 5
1 2
1 3
3 4
2 3
4 5

*/