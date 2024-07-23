import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][] = new int[3][2];
		//0개총시작 1개총종료 2스밍종료		[0]시간 [1]분
		Set<String> hs = new HashSet();
		Set<String> hs1 = new HashSet();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");//시간 입력받기
		for(int i=0; i<3; i++) {
			StringTokenizer ss = new StringTokenizer(st.nextToken(), ":");//hh:mm 분리
			arr[i][0] = Integer.valueOf(ss.nextToken());//시각
			arr[i][1] = Integer.valueOf(ss.nextToken());//분
		}//시간 입력 완료
		
		String line;
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			StringTokenizer stu = new StringTokenizer(line, " ");
			String time = stu.nextToken();//학생 시간
			String name = stu.nextToken();//학생 이름
			StringTokenizer tt = new StringTokenizer(time, ":");
			int hh = Integer.valueOf(tt.nextToken());//시각
			int mm = Integer.valueOf(tt.nextToken());//분
			
			int T = hh*100 + mm;
			int T0 = arr[0][0]*100 + arr[0][1];//개총시작
			int T1 = arr[1][0]*100 + arr[1][1];//개총종료
			int T2 = arr[2][0]*100 + arr[2][1];//스밍종료
			
			if(T <= T0)//시각보다 작거나 분보다 작거나 같으면
				hs.add(name);//이름 추가
			else if(T >= T1 && T <= T2) {
				hs1.add(name);
			}
		}
		int result = 0;
		for(String e : hs) if(hs1.contains(e)) result++;
		System.out.println(result);
	}
}