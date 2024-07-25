import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();//mobitel
		System.out.println(loop(input));
	}
	public static String loop (String input) {
		int len = input.length();//입력 받은 문자열의 길이
		StringBuilder zz = new StringBuilder();
		for(int i=0; i<len; i++) zz.append("z");//z로 이루어진 문자열을 compareTo를 이용해서 비교하기 위해 z로 만
		String result = zz.toString();//z로 이루어진 문자열
		for(int i=0; i<len-2; i++) {//0부터 len-2전까지 반복
			for(int j=i+1; j<len-1; j++) {//i+1부터 len-1전까지 반
				String str[] = input.split("");//입력받은 문자열을 한글자씩 배열로 쪼개서 저장
				
				StringBuilder sb[] = new StringBuilder[3];
				for(int k=0; k<3; k++) sb[k] = new StringBuilder();//3개의 단어를 만들어야 하므로 스트링빌더 3개 만듦
				for(int c=0; c<=i; c++) sb[0].append(str[c]);//0부터 i까지 단어 1번
				for(int c=i+1; c<=j; c++) sb[1].append(str[c]);//i+1부터 	j까지 단어 2번
				for(int c=j+1; c<len; c++) sb[2].append(str[c]);//j+1부터 끝까지 단어 3번
				StringBuilder SB = new StringBuilder();
				for(int q=0; q<3; q++) SB.append(sb[q].reverse().toString());//리버스한 단어3개들을 합침
				
				result = SB.toString().compareTo(result) < 0 ? SB.toString() : result;
				//SB.toString()을 기준으로 비교 했을 때 음수가 나오면 사전순으로 빠르기 때문에 음수가 나오면 result = SB.toString()을 해
			}
		}
		return result;//가장 사전순으로 빠른단어를 리
	}
}