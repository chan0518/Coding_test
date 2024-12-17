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
			long len = cal(mid); // 자른 나무 길이
			
			if(len < M) R = mid - 1;
			if(len > M) {
				res = mid;
				L = mid + 1;
			}
			if(len == M) {
				res = mid;
				break;
			}
			
//			System.out.println(mid);
//			System.out.println(len);
			
		}
		System.out.println(res);
	}
	
	static long cal (int len) {
		long sum = 0;
		for(int i=0; i<N; i++) if(arr[i] > len) sum += arr[i] - len;
		return sum;
	}
	
}