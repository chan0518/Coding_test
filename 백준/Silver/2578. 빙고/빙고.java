import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[][] = new int[5][5];
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}//빙고판 완
		int cnt=0;
		for(int i=0; i<5;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				cnt++;
				int num = Integer.valueOf(st1.nextToken());
				Loop1:
				for(int q=0; q<5; q++) {
					for(int w=0; w<5; w++) {
						if (arr[q][w] == num) {
							arr[q][w] = 0; 
							break Loop1;
						}
					}
				}
				int bingo = 0;
				for(int a=0; a<5; a++) {
					if(arr[a][0]==0 && arr[a][1] == 0 && arr[a][2]==0 && arr[a][3]==0 && arr[a][4]==0) bingo++;//가로줄 빙고
					if(arr[0][a]==0 && arr[1][a] == 0 && arr[2][a]==0 && arr[3][a]==0 && arr[4][a]==0) bingo++;//세로줄 빙고
				}
				if (arr[0][0]==0 && arr[1][1]==0 && arr[2][2]==0 && arr[3][3]==0 && arr[4][4]==0) bingo++;
				if (arr[4][0]==0 && arr[3][1]==0 && arr[2][2]==0 && arr[1][3]==0 && arr[0][4]==0) bingo++;
				if(bingo >= 3) {
					System.out.println(cnt);
					return;
				}
			}
		}
		
		//빙고조건
		
		
	}
}