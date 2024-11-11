import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
	static int n;
	static int x,y;
	static int[][] D = {
			{-1, 0},	// 상	0
			{0, 1},		// 우	1
			{1, 0},		// 하	2
			{0, -1},	// 좌	3
	};
	
	static void solution() throws Exception {
		String[] str = br.readLine().split("");
		n = str.length;
		int dir = 1;// 초기값 오른쪽 1
		int max = 0;
		int x = 0;
		int y = 0;
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<n; j++) {
				if(!str[j].equals("S") && !str[j].equals("L") && !str[j].equals("R")) continue;
				
				if(str[j].equals("S")) {
					x = x + D[dir][0];
					y = y + D[dir][1];
					int r = x*x + y*y;
					max = Math.max(max, r);
				} else if(str[j].equals("L")) {
					dir = (dir+3) % 4;
				} else if(str[j].equals("R")) {
					dir = (dir+1) % 4;
				}
			}
		}
		if(x == 0 && y == 0) sb.append(max);
		else sb.append("oo");
	}
}

/*

4
SLSSLLSSRS
LS
S
LLLLC

*/