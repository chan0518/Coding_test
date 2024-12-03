
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
// 116,232 kb, 1,989 ms
// 크루스칼 알고리즘이용
public class Solution{
	
	static Edge[] edgeList;
	static int[] parent;

	public static void makeSets() {
		for(int i=0; i<parent.length; i++) parent[i] = i;
	}
	public static int find(int a){
		if(parent[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parent[a] = find(parent[a]);
	}	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
	
		parent[bRoot] = aRoot;
		return true;
	}	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());
        
        for(int tc=1; tc<=TC; ++tc) {
        	
        	StringTokenizer st = new StringTokenizer(br.readLine().trim());
        	int vertexCount = Integer.parseInt(st.nextToken());
        	int edgeCount = Integer.parseInt(st.nextToken());
        	parent = new int[vertexCount+1];
        	edgeList = new Edge[edgeCount];	
        	
        	for(int i=0; i<edgeCount; ++i){
        		st = new StringTokenizer(br.readLine().trim());
        		edgeList[i] = new Edge(Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        	}//간선 저장
        	
        	makeSets();
        	// 간선비용이 작은 순서대로 정렬
        	Arrays.sort(edgeList);
        	
        	long result = 0; /////////////////////////주의: 100만비용의 간선으로 최대 10만개 정점일수 있으므로 int형 안됨!!//////////////////////////////////
        	int count=0;// 연결 간선수
        	for(Edge edge : edgeList){
        		if(union(edge.from,edge.to)){ // 싸이클이 발생하지 않았으면
        			result  += edge.weight;
        			// 연결 간선수가 정점수-1이면 다 연결한 것임.
        			if(++count == vertexCount-1) break;
        		}
        	}
        	System.out.println("#"+tc+" "+result);
        }
    }
    
	static class Edge implements Comparable<Edge>{
		int from,to,weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
}// end class
