import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.valueOf(br.readLine());
		int arr[] = new int[N+1];
		for(int i=0; i<N+1; i++) arr[i] = 1000000;
		arr[1] = 0;
		
		for(int i=1; i<N+1; i++) {
			int a1 = i + 1;//index
			int a2 = i * 2;//index
			int a3 = i * 3;//index
			
			if(a1 <= N) arr[a1] = Math.min(arr[a1], arr[i]+1);//value
			if(a2 <= N) arr[a2] = Math.min(arr[a2], arr[i]+1);//value
			if(a3 <= N) arr[a3] = Math.min(arr[a3], arr[i]+1);//value
		}
		System.out.println(arr[N]);
	}
}