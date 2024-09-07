import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N, M, cnt;
	static HashMap<Integer, ArrayList<Integer>> hmIn;
	static HashMap<Integer, ArrayList<Integer>> hmOut;
	static boolean[][] selected;
	
	public static void main(String args[]) throws Exception{
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			hmIn = new HashMap<>();
			hmOut = new HashMap<>();
			selected = new boolean[N+1][N+1];
			cnt = 0;
            
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(hmIn.get(a) == null) hmIn.put(a, new ArrayList<>());
				if(hmOut.get(b) == null) hmOut.put(b, new ArrayList<>());
				hmIn.get(a).add(b);
				hmOut.get(b).add(a);
			}
			
			for(int i=1; i<=N; i++) {
				selected[i][i] = true;
				dfs(i,i, hmIn);
				dfs(i,i, hmOut);
			}
			check();
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(cnt).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void check() {
		for(int i=1; i<=N; i++) {
			int n = 0;
			for(int j=1; j<=N; j++) {
				if(selected[i][j]) ++n;// true일때마다 1씩 더해줌
			}
			if(n == N) ++cnt;
		}
	}
	
	static void dfs(int start, int num, HashMap<Integer, ArrayList<Integer>> hm) {
		if(hm.get(num) == null) return;
		
		for(int i=0; i<hm.get(num).size(); i++){
			int nextNum = hm.get(num).get(i);
			if(!selected[start][nextNum]) {
				selected[start][nextNum] = true;
				dfs(start, nextNum, hm);
			}
		}
		selected[start][num] = true;
	}
	
}
