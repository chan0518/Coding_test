import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder();
	static int T;
	static int N, M, C;
	static int result, value1, value2;
	static int nextIdx;
	static int[][] map;
	static boolean[][] selected;
	static int[] honey; // 비트마스킹으로 구한 일꾼2번이 선택한 M크기의 꿀
	
	public static void main(String args[]) throws Exception{
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.valueOf(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-(M-1); j++) {
					honey = new int[M];
					value1 = bitMasking(i,j);
					value2 = value2(i,j+M);
					result = Math.max(result, value1 + value2);
				}
			}
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(result+"\n");
		}
		System.out.print(sb.toString());
	}
	static int value2(int x, int y) {
		boolean flag = false;
		int maxValue = 0, sumValue = 0;
		for(int i=x; i<N; i++) {
			if(flag) {
				for(int j=0; j<N-(M-1); j++) {
					sumValue = bitMasking(i, j);
					maxValue = Math.max(maxValue, sumValue);
				}
			}
			else {
				for(int j=y; j<N-(M-1); j++) {
					sumValue = bitMasking(i, j);
					maxValue = Math.max(maxValue, sumValue);
				}
				flag = true;
			}
		}
		return maxValue;
	}
	
	static int bitMasking(int i, int j) {
		int max = 0;
		int maxValue = 0;
		for(int k=0; k<M; k++) { // M의 갯수만큼 반복
			honey[k] = map[i][j+k];
		}// intSelect에 M가지의 비트마스킹을 할 벌꿀을 집어넣음 
		
		for (int bit = 1; bit < (1 << M); bit++) {// 1<<M은 2의M제곱
            int sum = 0;
            int sumValue = 0;
            // 각 비트가 1로 설정된 원소들을 부분집합에 포함시킴
            for (int l = 0; l < M; l++) {
                if ((bit & (1 << l)) != 0) { // bit가 5자리 라면 l이 0~4까지 5개의 자릿수를 &해서 0이 아니라면 2진수로 그 자릿수는 1이므로 밑에 값을 더해준다
                	//비트 마스킹으로 0~4를 선택한 l을 구함
                	sum += honey[l];
                	sumValue += honey[l] * honey[l];
                }
            }
            if(sum <= C && maxValue < sumValue) {
        		max = Math.max(max, sum);
        		maxValue = sumValue;
            }
        }
		return maxValue;
	}
	
}
