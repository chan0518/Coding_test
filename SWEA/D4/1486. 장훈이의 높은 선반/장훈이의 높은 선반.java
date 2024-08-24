
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
class Solution {
    static StringBuilder sb = new StringBuilder();
    static int T, N, B;
    static int[] arr;
    static int result;
    static ArrayList<Integer> li;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        T = Integer.valueOf(br.readLine());
         
        for (int tc = 1; tc <= T; tc++) {
        	//////////////////////////////////////////////////////////////////////////////////
            sb.append("#").append(tc).append(" ");
             
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            B = Integer.valueOf(st.nextToken());
            arr = new int[N];
            li = new ArrayList<>();
            result = Integer.MAX_VALUE;
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
            // 입력 완료
            
            dfs(0);
            
 
            sb.append(result - B).append("\n");
            
            //////////////////////////////////////////////////////////////////////////////////
        }
        System.out.println(sb.toString());
    }
    
    static int liSum() {
    	int sum = 0;
    	for(int e : li) sum += e;
    	return sum;
    }
    
    static void dfs(int start) {
    	int liSum = liSum();
    	if(liSum >= B) {
    		result = Math.min(result, liSum);
    		return;
    	}
    	for(int i=start; i<N; i++) {
    		li.add(arr[i]);
    		dfs(i+1);
    		li.remove(li.size()-1);
    	}
    }
    
}