import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	public static void main(String args[]) throws Exception{
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			solution();
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R,C;
	static String[][] map;
	static boolean[][][][] visited;
	static int[][] D = {
			{-1, 0},	// 상	0
			{1, 0},		// 하	1
			{0, -1},	// 좌	2
			{0, 1},		// 우	3
	};
	
	
	static void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		visited = new boolean[R][C][16][4];
		
		for(int i=0; i<R; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = str[j];
			}
		}// 입력 완료
		
		bfs();
	}
	
	
	static void bfs() {
		Queue<Data> q = new ArrayDeque<>();
		q.add(new Data(0,0,0,3));
//		visited[0][0][0][3] = true;
		
		while(!q.isEmpty()) {
			Data data = q.poll();
			int x = data.x;
			int y = data.y;
			int m = data.m;
			int d = data.d;
			
			if("^".equals(map[x][y])) {
				d = 0;
			} else if("v".equals(map[x][y])) {
				d = 1;
			} else if("<".equals(map[x][y])) {
				d = 2;
			} else if(">".equals(map[x][y])) {
				d = 3;
			} else if("_".equals(map[x][y])) {
				if(m == 0) d = 3; // 오른쪽
				else d = 2; // 왼쪽
			} else if("|".equals(map[x][y])) {
				if(m == 0) d = 1;// 아래
				else d = 0;// 위
			} else if(".".equals(map[x][y])) { // .은 그냥 넘어감 ?는 밑에 구현 했기에 똑같이 넘어감
			} else if("?".equals(map[x][y])) { // ?는 밑에 구현 되어 있어서 넘어감
			} else if("@".equals(map[x][y])) {
				sb.append("YES");
				return;
			} else if("+".equals(map[x][y])) {
				m++;
				if(m >= 16) m = 0;
			} else if("-".equals(map[x][y])) {
				m--;
				if(m < 0) m = 15;
			} else {
				m = Integer.parseInt(map[x][y]);
			}
			
			for(int i=0; i<4; i++) {// 이동
				if(!"?".equals(map[x][y]) && d != i) continue; // ?가 아니고 방향이 다르면 넘어감
//				if(x==0 && y==0) System.out.println("시작");
//				System.out.println("방향: " + dir(i) + " | x: " + x+ " y: " + y + " m: " + m);
				int nx = x + D[i][0];
				int ny = y + D[i][1];
				
				if(nx >= R) nx = 0;		if(nx < 0) nx = R-1;
				if(ny >= C) ny = 0;		if(ny < 0) ny = C-1;
				
				if(visited[nx][ny][m][d]) continue;
				visited[nx][ny][m][d] = true;
				q.add(new Data(nx,ny,m,i));
			}
		}
		sb.append("NO");
	}

	static String dir (int d) {
		if(d == 0) return "상";
		else if(d == 1) return "하";
		else if(d == 2) return "좌";
		else return "우";
	}
	
	static class Data {
		int x;	// x좌표
		int y;	// y좌표
		int m;	// 0~15 메모리
		int d;	// 0~3 방향	0:상		1:하		2:좌		3:우
		
		Data(int x, int y, int m, int d){
			this.x = x;
			this.y = y;
			this.m = m;
			this.d = d;
		}
	}
}


/*

3

2 6
6	>	-	-	v	.
.	^	-	-	_	@


2 6
5	>	-	-	v	.
.	^	-	-	_	@


2 6
.	>	-	-	v	.
.	^	-	-	?	@












#1 YES
#2 NO
#3 YES
#4 YES
#5 YES
#6 YES
#7 NO
#8 NO
#9 YES
#10 YES
#11 YES
#12 YES
#13 YES
#14 NO
#15 YES
#16 YES
#17 YES
#18 YES
#19 YES
#20 YES
#21 YES
#22 YES
#23 YES
#24 YES
#25 YES
#26 YES
#27 YES
#28 YES
#29 YES
#30 YES
#31 YES
#32 YES
#33 YES
#34 YES
#35 NO
#36 YES
#37 YES
#38 YES
#39 NO
#40 NO
#41 YES
#42 YES
#43 NO
#44 YES
#45 YES
#46 YES
#47 YES
#48 NO
#49 NO
#50 YES
#51 NO
#52 YES
#53 YES
#54 YES
#55 YES
#56 YES
#57 NO
#58 YES
#59 YES
#60 NO
#61 YES
#62 YES
#63 NO
#64 YES
#65 YES
#66 YES
#67 YES
#68 YES
#69 YES

*/