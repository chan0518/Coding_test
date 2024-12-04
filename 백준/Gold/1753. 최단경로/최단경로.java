import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E, K;
	static HashMap<Integer, List<int[]>> hm;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine().trim());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine().trim());
		
		arr = new int[V+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		hm = new HashMap<>();
		for(int i=1; i<=V; i++) hm.put(i, new ArrayList<>());
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 단방향
			hm.get(a).add(new int[] {b,w}); // 도착지랑 가중치를 담음 
//			hm.get(b).add(new int[] {a,w}); // 도착지랑 가중치를 담음
		}// 입력완료
		
		bfs(K);

		for(int i=1; i<=V; i++) {
			if(arr[i] == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(arr[i]);
		}
		
	}
	
	static void bfs(int start) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
		List<int[]> li = hm.get(start);
		arr[start] = 0;
		
		for(int[] e : li) {
//			System.out.println(start+ " | "+ e[0] + " | " + e[1]);
			
			if(e[1] < arr[e[0]]) {
				arr[e[0]] = e[1];
				q.add(new int[] {e[0],e[1]});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int node = cur[0];
			int weight = cur[1];
			
			li = hm.get(node);
			for(int[] e : li) {
//				System.out.println(node + " | "+ e[0] + " | " + e[1]);
				
				if(weight + e[1] < arr[e[0]]) {
					arr[e[0]] = weight + e[1];
					q.add(new int[] {e[0],weight + e[1]});
				}
			}
		}
	}
}