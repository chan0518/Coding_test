import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution{
	static StringBuilder sb = new StringBuilder(); // 출력
	static Queue<Person>[] qs; // 각 계단에 대한 큐 (계단마다 최대 3명이 들어갈 수 있음)
	static ArrayList<Person> persons; // 사람들을 저장하는 리스트
	static boolean[] visited; // 방문 여부를 저장하는 배열
	static Stair[] stairs; // 두 계단을 저장하는 배열
	static int N, ans; // N: 방의 크기, ans: 최소 시간
	
	static class Stair{
		int x, y ,d; // 계단의 위치 (x,y)와 계단의 길이 d
	
		Stair(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static class Person{
		int x,y; // 사람의 위치 (x,y)
		int stair; // 이용할 계단 0 또는 1
		int arriveTime; // 계단 도착 시간
		int stairTime; // 계단 진입 시간
		
		Person(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		private void setArriveTime() {
			this.arriveTime = Math.abs(x - stairs[stair].x) + Math.abs(y - stairs[stair].y);
		}
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++){
			sb.append("#"+test_case+" ");
			/////////////////////////////////////////////////////////////////////////////////////////////
			N = Integer.parseInt(br.readLine());
			
			persons = new ArrayList<>(); // 사람들 리스트 초기화
			qs = new ArrayDeque[2]; // 계단별 큐 초기화
			qs[0] = new ArrayDeque<Person>();
			qs[1] = new ArrayDeque<Person>();
			stairs = new Stair[2]; // 계단 배열 초기화
			ans = Integer.MAX_VALUE; // 최소 시간 초기화
			
			int stairIdx = 0; // 계단의 인덱스
			
			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num == 0) continue;
					else if(num == 1) persons.add(new Person(i, j));// 1이면 사람의 주소를 추가
					else {
						stairs[stairIdx] = new Stair(i, j, num);
						++stairIdx;
					}
				}
			}// 입력 완료
			
			dfs(0);
			
			/////////////////////////////////////////////////////////////////////////////////////////////
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}
	
	
	// 사람들에게 계단을 할당하는 함수
	static void dfs (int idx) {
		
		// 모든 사람에게 계단을 할당한 경우
		if(idx == persons.size()) {
			visited = new boolean[persons.size()]; // 방문 여부 배열 초기
			
			int cur = simulation();
			// 최소 시간을 업데이트
			
			ans = Math.min(ans, cur);
			return;
		}
		
		// 첫번째 계단 이용하기 
		persons.get(idx).stair = 0; // 현재 사람에게 첫번째 계단 할당
		persons.get(idx).setArriveTime(); // 첫번째 계단까지 도착 시간 계산
		dfs(idx + 1); // 다음 사람에 대해 재귀 호출
		
		// 두번째 계단 이용하기
		persons.get(idx).stair = 1; // 현재 사람에게 두번째 계단 할당
		persons.get(idx).setArriveTime(); // 두번째 계단까지 도착 시간 계산
		dfs(idx + 1); // 다음 사람에 대해 재귀 호출
	}
	
	static int simulation() {
		int cnt = 0; // 계단을 모두 내려간 사람 수
		int time = 1; // 시간 초기화
		
		while(true) {
			// 계단을 내려가고 있는 사람들 처리
			for(Queue<Person> q : qs) {
				int size = q.size();
				
				for(int i = 0 ; i < size ; ++i) {
					Person p = q.poll();
					Stair s = stairs[p.stair];
					
					// 계단을 모두 내려갔다면 큐에 다시 넣지 않음
					if(p.stairTime + s.d <= time) {
						continue;
					}
					
					// 아직 다 내려가지 않은 사람은 다시 큐에 넣음
					q.offer(p);
				}
			}
			
			// 모든 사람이 계단을 내려갔고, 두 계단의 큐가 비어있다면 종료
			if(cnt == persons.size() && qs[0].isEmpty() && qs[1].isEmpty()) {
				return time; // 현재 시간을 반환
			}
			
			// 사람들을 계단 큐에 넣기
			for(int i = 0 ; i < persons.size() ; ++i) {
				if(visited[i]) continue; // 이미 처리된 사람은 건너뜀
				
				Person p = persons.get(i);
				Queue<Person> q = qs[p.stair];
				
				// 사람이 계단에 도착했고, 계단 큐에 자리가 있으면 계단을 내려가게 함
				if(p.arriveTime + 1 <= time && q.size() < 3) {
					p.stairTime = time; // 계단에 진입한 시간 설정
					visited[i] = true; // 방문 처리
					q.offer(p); // 계단 큐에 사람 추가
					cnt++; // 계단을 내려가는 사람 수 증가
				}
			}
			time++; // 시간 증가
		}
	}
}
