import java.util.Arrays;
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
	static int V, E;
	static long result;
	static int[] parent;
	static int[][] arr;
	
	static void S() throws Exception {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parent = new int[V+1];
		for(int i=1; i<=V; i++) parent[i] = i;

		arr = new int[E][3];
		for(int i=0; i<E; i++) {// 간선의 수 만큼 입력 받음
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> Integer.compare(a[2], b[2]));// arr[2](가중치) 기준으로 정렬
		
		result = 0; // 주의 100만의 비용의 간선으로 최대 10만개 정점일수 있으므로 int형 안됨
		int cnt = 0; // 연결 간선수
		
		for(int i=0; i<E; i++) {// 간선만큼 반복
			int a = arr[i][0];
			int b = arr[i][1];
			int c = arr[i][2];
			
			if(union(a, b)) {// 싸이클이 발생하지 않았다면
				result += c;
				// 연결 간선수가 정점수 -1 이라면 다 연결한 것임
				if(++cnt == V-1) break;
			}
		}
	}
	
	static int find(int a) {// a의 부모가 a라면 정점을 찾은거니 a리턴
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);// a의 부모가 a가 아니라면 a의 부모의 부모가 있으므로 a의 부모를 매개변수로 또 부모를 찾음
	}
	
	static boolean union(int a, int b) {// 합치지 못하면 false, 합치면 true
		int aRoot = find(a);// a의 정점 찾기
		int bRoot = find(b);// b의 정점 찾기
		
		if(aRoot == bRoot) return false;// 부모가 같으면 합치지 못함
	
		if(aRoot < bRoot) parent[bRoot] = aRoot; // b루트 정점의 부모를 a루트로 바꿔줌 유니온 해줌
		else parent[aRoot] = bRoot;
		
		return true;
	}
	
	
}