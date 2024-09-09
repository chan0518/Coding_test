import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge {
	int s;
	int e;
	int cost;

	Edge(int s, int e, int cost) {
		this.s = s;
		this.e = e;
		this.cost = cost;
	}
}

public class Main {
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		N++;
		M++;

		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(A, B, C));
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) parent[i] = i;

		Collections.sort(edgeList, (e1, e2) -> e1.cost - e2.cost); // 오름차순

		int cost1 = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);

				if (edge.cost == 0) cost1++;
			}
		}

		for (int i = 0; i < N; i++) parent[i] = i;

		int cost2 = 0;
		for (int i = edgeList.size() - 1; i >= 0; i--) {
			Edge edge = edgeList.get(i);

			if (find(edge.s) != find(edge.e)) {
				union(edge.s, edge.e);

				if (edge.cost == 0) cost2++;
			}
		}

		int result = cost1 * cost1 - cost2 * cost2;
		System.out.println(result);
	}

	public static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) parent[y] = x;
	}

}