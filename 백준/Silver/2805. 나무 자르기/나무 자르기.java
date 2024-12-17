import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main{
	
	static int N, M, res;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		int L = 1;
		int R = arr[N-1];

		while(L <= R) {
			int mid = (L + R) / 2;
			
			if (cal(mid) >= M) { // 잘린 나무가 M보다 크거나 같으면
                res = mid; // 최대 높이 갱신
                L = mid + 1; // 더 큰 높이를 탐색
            } else {
                R = mid - 1; // 나무가 부족하면 더 낮은 높이 탐색
            }
			
		}
		System.out.println(res);
	}
	
	static long cal (int len) {
		long sum = 0;
		for(int i=0; i<N; i++) if(arr[i] > len) sum += arr[i] - len;
		return sum;
	}
	
}




/*

4 8
20 15 10 17

4 6
20 15 10 17


*/