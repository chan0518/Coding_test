import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] arr;
	static int N;
	static int Z;
	static int M;
	static int K;
	
	public static void check() {
		Loo1:
		for(int i=1; i<=N; i++) {
			int idx = 1;
			boolean[] obtain = arr.clone();
			while(true) {
				if(idx == Z)
					break;
				idx+=i;
				if(idx > N)
					idx-=N;
				if(obtain[idx])//장애물이 true이기 때문에 장애물을 만나면 break
					continue Loo1;
				else obtain[idx] = true;
                //방문한곳에 또 방문하면 무한루프이므로 true를 해줌
			}
			K=i;//장애물을 만나지 않았다면 i가 K가 된다
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		Z = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		arr = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++)
			arr[Integer.valueOf(st.nextToken())] = true;//장애물들은 true로 
		check();
		System.out.println(K);
		
	}
}