import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> hm = new HashMap<>();
	
	public static void main(String args[]) throws Exception
	{
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
//		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		
		tcLoop:
		for(int tc = 1; tc <= T; tc++)
		{
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append("#").append(tc).append(" ");
			int N = Integer.valueOf(br.readLine());
			String[] input = br.readLine().split("");
			Deque<String> stack = new LinkedList<>();
			
			hm.put(")", "(");
			hm.put("}", "{");
			hm.put("]", "[");
			hm.put(">", "<");
			
			for(int i=0; i<N; i++) {
				if(stack.isEmpty() || input[i].equals("(") || input[i].equals("{") || input[i].equals("[") ||input[i].equals("<")) {
					stack.addLast(input[i]);
				}
				else if(stack.peekLast().equals(hm.get(input[i]))) {
					stack.removeLast();//괄호의 짝이 맞으면 삭제
				}
				else {
					sb.append(0).append("\n");
					continue tcLoop;
				}
			}
			if(!stack.isEmpty()) sb.append(0).append("\n");
			else sb.append(1).append("\n");
			/////////////////////////////////////////////////////////////////////////////////////////////
			
		}
		System.out.println(sb.toString());
	}
}