import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<LinkedList<Integer>> li = new ArrayList<>();
	static LinkedList<Integer> arr;
	static int max = 0;
	
	public static void Cal() {
		for(int i=0; i<N; i++) {
			int cnt =0;
			HashSet<Integer> hs = new HashSet<>(li.get(i));
			int idx=0;
			for(int j=0; j<li.get(i).size(); j++) {
				idx = li.get(i).get(j);//arr의 값 idx에 저장
				for(int e : li.get(idx)) hs.add(e);
			}
			hs.remove(i);
			cnt = hs.size();
			max = Math.max(max, cnt);
		}
	}
	
	public static void friendInput(String[] str) {
		arr = new LinkedList<>();
		for(int i=0; i<N; i++) {
			if (str[i].equals("Y")) arr.add(i);//arr에 친구 저장
		}
		li.add(arr);//친구목록을 li에 저장
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.valueOf(br.readLine());
		for(int i=0; i<N; i++) {
			String[] str = br.readLine().split("");
			friendInput(str);
		}//입력완료
		Cal();
		System.out.println(max);
//		for(LinkedList<Integer> e1 : li) System.out.println(e1);
	}
}
