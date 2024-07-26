import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");//거인의 수 | 센티키 | 망치횟수
		int N = Integer.valueOf(input[0]);//거인 수
		int senti = Integer.valueOf(input[1]);//센티 키
		int hammer = Integer.valueOf(input[2]);//망치 횟수
		
		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			int giant = Integer.valueOf(br.readLine());
			if(giant >= senti) pq.add(giant);//거인의 키가 센티보다 크거나 같으면 우선순위큐에 추가
		}
		
		int hammerUse = 0;
		while(hammer > 0 && pq.size() != 0) {//거인의 키가 센티보다 크거나 같다면 반복
			if(pq.peek() != 1 && pq.peek()/2 < senti) pq.remove();//제일 큰 거인을 /2했을 때 센티보다 작다면 삭제
			else if (pq.peek() != 1) pq.add(pq.poll()/2);//센티보다 크거나 같다면 /2를 하고 다시 큐에 추가
			
			hammerUse++;//횟수 증가
			hammer--;
		}
		if(pq.size() == 0) {
			System.out.println("YES");
			System.out.println(hammerUse);
		}
		else {
			System.out.println("NO");
			System.out.println(pq.peek());
		}
	}
}