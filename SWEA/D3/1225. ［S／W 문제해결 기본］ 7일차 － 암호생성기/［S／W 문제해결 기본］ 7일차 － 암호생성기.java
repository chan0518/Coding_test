import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int[] arr = new int[8];
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		int T = Integer.valueOf(br.readLine());
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++){
			
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			int cnt = 1;
			int idx = 0;
			
			br.readLine();
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<8; i++) arr[i] = Integer.valueOf(st.nextToken());
			
			Loop1:
			while(true) {
				for(int i=0; i<8; i++) {
					arr[i] -= cnt++;
					if(arr[i] <= 0) {
						arr[i] = 0;
						idx = i+1;
						if(idx >= 8) idx = 0;
						break Loop1;
					}
					if(cnt >= 6) cnt = 1;
				}
			}
			
			
			for(int i=0; i<8; i++) {
				if(idx >= 8) idx =0;
				sb.append(arr[idx++]+" ");
			}
			sb.append("\n");
			/////////////////////////////////////////////////////////////////////////////////////////////

		}
		System.out.println(sb.toString());
	}
}