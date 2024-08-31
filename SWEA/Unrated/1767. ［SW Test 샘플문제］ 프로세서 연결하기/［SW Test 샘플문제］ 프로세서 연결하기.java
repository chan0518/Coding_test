import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int T, N;
	static int result, Core;// result = 최소전선의 수, Core = 최대 코어의 수
	static int[][] map; // 맵
	static ArrayList<int[]> process; // 가장자리가 아닌 프로세스들의 좌표
	static boolean[][] selected; // 전선연결이 가능한지 여부 (프로세서가 있거나 전선이 있다면 전선연결이 불가능)
	static int[][] D = { //시계방향
			{-1,0},		// 상
			{0,1},		// 우
			{1,0},		// 하
			{0,-1},		// 좌
	};
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			selected = new boolean[N][N];
			process = new ArrayList<>();
			result = Integer.MAX_VALUE;
			Core = 0;
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						selected[i][j] = true; // 프로세스가 있다면 true 처리
						if(i != 0 && i != N-1 && j != 0 && j != N-1) process.add(new int[] {i,j});// ArrayList에 프로세스의 좌표를 추가
					}
				}
			}// 입력 완료
			
			dfs(0, 0, 0);// idx = 프로세스의 0번째 좌표부터 dfs를 돎, cnt = 전선의 길이, core = 연결된 코어의 수;
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(result+"\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int idx, int cnt, int core) {
		if(idx == process.size()) {// 리턴 조건 프로세스의 모든 좌표의 전선의 길이를 구했다면
			if(Core < core) {// 현재 저장된 Core보다 core가 더 크다면 Core의 값을 큰값으로 바꿔준다 그리고 전선의 값도 그에 맞게 바꿔줌
				Core = core;
				result = cnt;
			}
			else if(Core == core) result = Math.min(cnt, result);// 코어의 수가 같을 때 작은 전선의 값을 저장
//			System.out.printf("coreNum:%d core:%d result:%d cnt:%d\n", coreNum, core, result, cnt);
			return;
		}
		
		int x = process.get(idx)[0];
		int y = process.get(idx)[1];
		
		for(int[] d : D) { // 4가지 방향마다 계속 더해줘서 전선연결이 가능한지 확인
			int nx = x + d[0];
			int ny = y + d[1];
			boolean flag = false;;
			
			// 전선연결이 가능하다면 계속 한 방향으로 나아가면서 가장자리까지 도달함
			// 도달했다면 그 좌표에서 dfs로 다음 프로세스의 좌표로 전선길이를 구함
			while(0 <= nx && nx < N && 0 <= ny && ny < N && !selected[nx][ny]) {
				if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {// 가장 자리라면
					
					int num = (Math.abs(x - nx) + Math.abs(y - ny));// 전선의 길이 만큼 더해줌
					int xx = nx;
					int yy = ny;
					
					for(int i=0; i<num; i++) {
						selected[xx][yy] = true; // true 선택처리
						xx -= d[0];
						yy -= d[1];
					}
					dfs(idx+1, cnt+num, ++core);
					flag = true;
					--core;
					for(int i=0; i<num; i++) {
						xx += d[0];
						yy += d[1];
						selected[xx][yy] = false; // false 선택처리
					}
					break;
				}
				// 계속 더해줘서 전선연결이 가능한지 확인함
				nx += d[0];
				ny += d[1];
			}
			if (!flag) dfs(idx+1, cnt, core);
		}
		
		
	}
	
	// 디버그용
//	static void mapInfo() {
//		System.out.println();
//		for(int[] e1 : map) {
//			for(int e2 : e1) System.out.print(e2);
//			System.out.println();
//		}
//	}
//	
//	static void processInfo() {
//		System.out.println();
//		for(int[] e1 : process) {
//			System.out.println(e1[0] + "|"+e1[1]);
//		}
//	}
//	
//	static void selectedInfo() {
//		System.out.println();
//		for(boolean[] e1 : selected) {
//			for(boolean e2 : e1) System.out.print(e2 == true ? "O " : "X ");
//			System.out.println();
//		}
//	}
	
}