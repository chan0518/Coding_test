import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static LinkedList<Integer> resultArr = new LinkedList<>();
	
	public static void Cal(LinkedList<Integer> li) {
		int sum = 0;
		for(int i=0; i<li.size()-1; i++) {
			int num = li.get(i) - li.get(i+1);
			num = num < 0 ? num*-1 : num;
			sum += num;
		}
		max = Math.max(max, sum);
	}
	
	public static void dfs(int[] arr, boolean[] visited, LinkedList<Integer> li, int N) {
		if(li.size() == N) {
			Cal(li);
			//System.out.println(li);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			li.add(arr[i]);
			dfs(arr, visited, li, N);
			
			visited[i] = false;
			li.remove(li.size()-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		LinkedList<Integer> li = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) arr[i] = Integer.valueOf(st.nextToken());
		//입력 완료
		
		dfs(arr, visited, li, N);
		
		System.out.println(max);
	}
}