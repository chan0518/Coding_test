import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		dfsC(1);
	}
	
	static int N, M;
	static boolean[] visited;
	static ArrayList<Integer> li = new ArrayList<>();
	
	
	public static void dfsC(int start) {
		if(li.size() == M) {
			for(int e : li) System.out.print(e + " ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<=N; i++) {
			li.add(i);
			dfsC(i+1);
			li.remove(li.size()-1);
		}
	}
}


/*

[오류 찾기]

start = 1
첫 번째 for문
1넣음
dfs
2넣음
꽉 차서 탈출
2삭제
3넣음
탈출
3삭제
4넣음
탈출
4삭제
dfs탈출
1삭제

두 번째 for문
i=start가 2라서
2넣음
start는 1 그대로 이므로
1+1인 2가 들어감

그래서 계속 2 2 가 나옮

start + 1이 아니라 i + 1로 만들어야 정상 구동


*/