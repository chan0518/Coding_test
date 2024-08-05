import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	static ArrayList<House> chickenList = new ArrayList<>();
	static ArrayList<House> houseList = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	
	static class House{
		int x, y;
		public House(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void Cal(ArrayList<House> selectedChickens) {
		int distance = 0;
		for(House house : houseList) {
			int t_min = Integer.MAX_VALUE;
			for(House chicken : selectedChickens) {
				int x = Math.abs(house.x - chicken.x);
				int y = Math.abs(house.y - chicken.y);
				int chickenDistance = x + y;
				t_min = Math.min(chickenDistance, t_min);
			}
			distance += t_min;
		}
		answer = Math.min(distance, answer);
	}
	
	public static void dfs(int start, ArrayList<House> selectedChickens) {
		if(selectedChickens.size() == M) {
			Cal(selectedChickens);
			return;
		}
		
		for(int i = start; i < chickenList.size(); i++) {
			selectedChickens.add(chickenList.get(i));
			dfs(i + 1, selectedChickens);
			selectedChickens.remove(selectedChickens.size() - 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) {
					chickenList.add(new House(i, j));
				} else if(temp == 1){
					houseList.add(new House(i, j));
				}
				arr[i][j] = temp;
			}
		}
		
		dfs(0, new ArrayList<House>());
		System.out.println(answer);
	}
}
