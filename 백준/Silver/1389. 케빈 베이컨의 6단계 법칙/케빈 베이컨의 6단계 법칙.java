import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int result = 0;
	static ArrayList<ArrayList<Integer>> li = new ArrayList<>();
	static Deque<int[]> dq = new LinkedList<>();
	
	public static int getKB(int num) {
		int kCnt = 0;
		for(int i=1; i<=N; i++) {
			if(i == num) continue;
			
			boolean[] visited = new boolean[N+1];
			
			dq.offer(new int[] {num, 0});
			visited[num] = true;
			
			while(!dq.isEmpty()) {
				int[] current = dq.poll();
				
//				System.out.println("("+current[0]+", "+current[1]+"), " +i);
				
				if(current[0] == i) {
					kCnt += current[1];
					dq.clear();
					break;
				}
				
				for(int j=0; j<li.get(current[0]).size(); j++) {
					if(!visited[li.get(current[0]).get(j)]) {
						dq.offer(new int[] {li.get(current[0]).get(j), current[1]+1});
						visited[li.get(current[0]).get(j)] = true;
					}
				}
			}
		}
		return kCnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		
		for(int i=0; i<=N; i++) li.add(new ArrayList<>());//N+1개 추가
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.valueOf(st.nextToken());
			int num2 = Integer.valueOf(st.nextToken());
			li.get(num1).add(num2);//num1번 리스트에 num2값을 넣음
			li.get(num2).add(num1);//num2번 리스트에 num1값을 넣음
		}
		for(int i=N; i>0; i--) {
			if(min >= getKB(i)) {
				min = getKB(i);
				result = i;
			}
		}
		System.out.println(result);
		
//		for(ArrayList<Integer> e: li) {
//			System.out.println(e);
//		}
		
		
	}
}