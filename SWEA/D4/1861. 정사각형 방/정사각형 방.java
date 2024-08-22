import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int N, depth, num, max;
	static int[][] map;
	static boolean flag;
	static int[][] D = {
			{-1,0},		//상
			{1,0},		//하
			{0, 1},		//좌
			{0, -1},	//우
	};
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.valueOf(br.readLine());
//		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = Integer.parseInt(br.readLine());
			flag = false;
			max = 0;
			map = new int[N][N];
			num = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}// 입력 완료 
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					depth = 1;
					dfs(i,j);
					if(depth > max) {
						max = depth;
						num = map[i][j];
					}
					if(depth == max && map[i][j] < num) num = map[i][j];
				}
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(num).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int x ,int y){
		if(flag) return;
		
		for(int[] d : D) {
			int nx = x + d[0];
			int ny = y + d[1];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == (map[x][y]+1)) {
				++depth;
				dfs(nx,ny);
			}
		}
		
		
	}
	
}