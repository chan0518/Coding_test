import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static LinkedList<Integer> li = new LinkedList();
	static boolean[] visited = new boolean[10];
	static int arr[] = {0,1,2,3,4,5,6,7,8,9};
	static int N;
	static String[] notEqual;
	static int max = 0;
	static int min = 0;
	static boolean isMin = true;
	static ArrayList<String> answer = new ArrayList<>();
	
	public static void Cal() {
		for(int i=0; i<N; i++) {
			if (notEqual[i].equals("<")) {
				if(li.get(i) > li.get(i+1)) return;
			}
			else {
				if(li.get(i) < li.get(i+1)) return;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N+1; i++) sb.append(li.get(i));
		answer.add(sb.toString());
	}
	
	public static void dfs() {
		if(li.size() == N+1) {
			Cal();
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			li.add(i);
			dfs();
			visited[i] = false;
			li.remove(li.size()-1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		notEqual = br.readLine().split(" ");
		dfs();
		Collections.sort(answer);
		System.out.println(answer.get(answer.size() - 1));
		System.out.println(answer.get(0));
	}
}
