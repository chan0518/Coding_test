import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M, V;
	static boolean[] visited;
	static List<Integer> li = new ArrayList<>();
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>(); // 양방향 그래프
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(hm.get(from) == null) hm.put(from, new ArrayList<>());
			if(hm.get(to) == null) hm.put(to, new ArrayList<>());
			hm.get(from).add(to);
			hm.get(to).add(from);
		}
		
		visited = new boolean[N+1];
		visited[V] = true;
		dfs(V);
		
		sb.append("\n");

		visited = new boolean[N+1];
		bfs(V);

		System.out.println(sb.toString());
		
//		System.out.println(hm);
	}
	
	static void dfs(int x) {
		
		if(hm.get(x) == null) hm.put(x, new ArrayList<>());
		Collections.sort(hm.get(x));
		int size = hm.get(x).size();
		
		sb.append(x).append(" ");
		
		for(int i=0; i<size; i++) {
			int nx = hm.get(x).get(i);
			
			if(visited[nx]) continue;
			visited[nx] = true;
			dfs(nx);
		}
	}

	static void bfs(int a) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			int size = hm.get(x).size();
			
			sb.append(x).append(" ");
			
			for(int i=0; i<size; i++) {
				int nx = hm.get(x).get(i);
				
				if(visited[nx]) continue;
				visited[nx] = true;
				q.add(nx);
			}
		}
		
	}
	
}
