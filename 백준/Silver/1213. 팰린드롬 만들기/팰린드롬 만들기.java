import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static String solo = "";
	
	public static boolean check(String[] str) {
		int alone = 0;
		for(int i=0; i<str.length; i++) {
			if(i < str.length-1 && str[i].equals(str[i+1])) {//값이 앞이랑 뒤가 같다면
				i++;
				continue;
			}
			else {
				if (alone == 0) {
					alone++;
					solo = str[i];
					continue;
				}
				else return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		Arrays.sort(str);
		LinkedList<String> li = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		if(!check(str)) {
			System.out.println("I'm Sorry Hansoo");//false라면
			return;
		}
		
		if(!solo.equals(""))li.add(solo);//혼자 남은 값 추가
		boolean FirstLast = true;
		boolean soloTF = true;
		for(int i=0; i<str.length; i++) {
			if(soloTF && str[str.length-1-i].equals(solo)) {
				soloTF = false;
				continue;
			}
			if (FirstLast) li.addFirst(str[str.length-1-i]);
			else li.addLast(str[str.length-1-i]);
			FirstLast = FirstLast == true ? false : true;//스위치 온오프
		}
		for(String e: li) System.out.print(e);
	}
}
