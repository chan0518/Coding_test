import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	
	static StringBuilder sb = new StringBuilder();
	static int N, startNode;
	static HashSet<Integer> hs;
	static HashMap<Integer, ArrayList<Integer>> hm;
	static int Depth, Num;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			startNode = Integer.parseInt(st.nextToken());
			Depth = 0;
			Num = 0;
			hs = new HashSet<>();
			hm = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N/2; i++) {
				int nodeNum = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if(!hm.containsKey(nodeNum)) {
					hm.put(nodeNum, new ArrayList<>());// nodeNum이 없다면 미리 ArrayList를 만들어서 value를 닮을 공간을 만들어 준다
				}
				hm.get(nodeNum).add(value);
				
			}
			// 입력 완료
			
			dfs();
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(Num+"\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {startNode, 0});
		hs.add(startNode);
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int node = current[0];
			int depth = current[1];
			
			if(hm.get(node) != null) {// 자신이 가르키고 있는 번호가 있다면 for문이 돌아가고 가르키는 번호가 없고 자신이 마지막이라면 넘어감
				for(int i=0; i<hm.get(node).size(); i++) {
					int num = hm.get(node).get(i);
					if(!hs.contains(num)){
						q.add(new int[]{num, depth+1});
						hs.add(num);
					}
				}
			}
			if(Depth < depth || (Depth == depth && Num < node)){
				Depth = depth;
				Num = node;
			}
		}
	}
}