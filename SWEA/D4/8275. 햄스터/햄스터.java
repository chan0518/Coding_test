import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	static int N, X, M;
	static int s, e, n; // start ~ end 까지의 n개가 있다는 뜻
	static int[][] valid;
	static int[] num;
	static int[] result;
	
	static void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		valid = new int[M][3];
		num = new int[N];
		result = new int[N];
		Arrays.fill(result, -1);// 최대값으로 채워서 사전순으로 꼴찌를 만듦
		
		for(int i=0; i<M; i++) { // M번 반복
			st = new StringTokenizer(br.readLine());
			valid[i][0] = Integer.parseInt(st.nextToken());
			valid[i][1] = Integer.parseInt(st.nextToken());
			valid[i][2] = Integer.parseInt(st.nextToken());
		} // 조건 저장
		
		dfs(0);
		if(result[0] == -1) sb.append(-1);
		else for(int i=0; i<N; i++) sb.append(result[i]).append(" ");
	}
	
	static void dfs(int index) {
	    if (index == N) { // 모든 자리가 채워졌으면
	        check();
	        return;
	    }

	    for (int i = 0; i <= X; i++) { // 0부터 X-1까지 반복
	        num[index] = i;  // 현재 자리의 값을 설정
	        dfs(index + 1);  // 다음 자리로 이동
	    }
	}
	
	static void check () {
		int sum = 0;
		
		for(int i=0; i<M; i++) { // 조건 갯수
			sum = 0;
			for(int j=valid[i][0]-1; j<=valid[i][1]-1; j++) { // s부터 e까지 반복
				sum += num[j];
			}
			if(sum != valid[i][2]) return;// 조건이 틀리면 바로 탈출
		}
		
		//갯수 같은지 확인
		int sum1=0,sum2=0;
		for(int i=0; i<N; i++) {
			sum1 += result[i];
			sum2 += num[i];
		}
		if(sum1 > sum2) return;
		else if (sum1 < sum2) {
//			System.out.println("비교");
//			System.out.println(Arrays.toString(result));
//			System.out.println(Arrays.toString(num));
			result = num.clone();
		}
		// sum1 == sum2 라면 통과
		
		// 여기까지 왔다는 말은 조건에 충족한다는 뜻
		for(int i=0; i<N; i++) {// 사전순으로 빠른걸 result로 교체
			if(result[i] > num[i]) {
				result = num.clone();
				break;
			} else if (result[i] < num[i]) {
				break;
			}
		}// 교체 완료
	}
}

/*

3
3 5 1
1 2 5
3 5 2
1 2 6
2 3 7
4 5 2
1 3 15
3 4 4

*/