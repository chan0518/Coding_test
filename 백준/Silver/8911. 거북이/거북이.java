import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.valueOf(br.readLine());
		
		for(int TC=0; TC<num; TC++) {
			int arr[] = {0,0,0,0};//현재 위치 0북 1동 2남 3서
			int MAX_arr[] = new int[4];//최대 값 0북 1동 2남 3서
			int idx = 1000;
			String input[] = br.readLine().split("");
			int n = input.length;
			for(int i=0; i<n; i++) {
				String str = input[i];
				if(str.equals("L")) idx--;//좌회전
				else if(str.equals("R")) idx++;//우회전
				else if(str.equals("F")) {//전진
					if(arr[(idx+2) % 4] == 0) arr[idx % 4]++;//반대방향 숫자가 0이면 원래방향으로 전진
					else if (arr[(idx+2) % 4] > 0) arr[(idx+2) % 4]--;//반대 방향 숫자가 0보다 크면 반대방향 깍기
//					MAX_arr[idx % 4] = Math.max(MAX_arr[idx%4], arr[idx%4]);//MAX값 구하기
				}
				else if(str.equals("B")) {//후진
					if(arr[idx % 4] == 0) arr[(idx+2) % 4]++;//원래방향 숫자가 0이면 반대방향으로 전진
					else if (arr[idx % 4] > 0) arr[idx % 4]--;//원래방향 숫자가 0보다 크면 원래방향숫자 깍기
//					MAX_arr[idx % 4] = Math.max(MAX_arr[idx%4], arr[idx%4]);//MAX값 구하기
				}
				MAX_arr[0] = Math.max(MAX_arr[0], arr[0]);
				MAX_arr[1] = Math.max(MAX_arr[1], arr[1]);
				MAX_arr[2] = Math.max(MAX_arr[2], arr[2]);
				MAX_arr[3] = Math.max(MAX_arr[3], arr[3]);
			}//TC 1바퀴 끝
			System.out.println((MAX_arr[0]+ MAX_arr[2])*(MAX_arr[1]+MAX_arr[3]));//넓이
		}
	}
}