
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 섬의 수
	static int M; // 다리의 수
	static PriorityQueue<Edge> pq;
	static int[] parents;
	static int start; // 공장의 시작 정점
	static int end; // 공장의 끝 정점
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pq = new PriorityQueue<>();
		parents = new int[N + 1];
		
		for (int i = 1; i <= N; i++) parents[i] = i;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pq.offer(new Edge(a, b, c)); // a = 시작 정점, b = 끝 정점, c = 비용
		}// 입력 완료
		
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken()); // 공장 정점
		end = Integer.parseInt(st.nextToken()); // 공장 정점
		
		cruscal();
		System.out.println(result);
	}

	//크루스칼
	static void cruscal() {
		for (int i = 0; i < M; i++) {
			Edge e = pq.poll(); // 우선순위 q에 넣었던 값 반환
			
			if (find(e.s) != find(e.e)) {
				union(e.s, e.e);// 시작점과 끝점 병합
				if(find(parents[start]) == find(parents[end])){
					result = e.cost;
					return; // 루트노드가 같다면 cost반환
					// 우선순위 큐를 이용해 무거운중량을 버티는 다리부터 병합하다가 공장의 시작점과 끝점이 연결되면 끝
				}
			}
		}
	}

	// 유니온
	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a > b) parents[a] = b;
		else parents[b] = a;
	}
	
	// 파인드
	static int find(int v) {
		if (parents[v] == v) return v;
		else return parents[v] = find(parents[v]);
	}
	
	// 엣지
	static class Edge implements Comparable<Edge> {
		int s; // 시작 정점
		int e; // 끝 정점
		int cost; // 비용

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o1) {
			return o1.cost - this.cost;// o1.cost 랑 this.cost 둘 중 큰값이 앞으로
		}
	}
}
