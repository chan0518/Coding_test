import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int cnt = 0;
		
		int milk = 0;
		for(int i=0; i<N; i++) {
			if(arr[i] == milk) {
				milk = (milk + 1) % 3;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}