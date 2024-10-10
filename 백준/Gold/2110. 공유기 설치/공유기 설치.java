import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,C, result;
    static List<Integer> house;
    static List<Integer> router;
    
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	result = 0;
    	
    	house = new ArrayList<>();
    	for(int i=0; i<N; i++) {
    		house.add(Integer.parseInt(br.readLine()));
    	}// 입력 완료
    	Collections.sort(house);
    	
    	binary();
    	System.out.println(result);
    }
    
    static void binary() {// 이진탐색
    	int L = 1;	// 공유기가 바로 옆집에 있으면 최솟값으로 1이 나옴
    	int R = house.get(house.size()-1) - house.get(0);// 최대값으로 제일 좌표가 큰값 - 작은값으로 정해줌
    	
    	while(L <= R) {
    		int m = (L + R) / 2;
    		if(Cal(m)) {	//	참이라면 값을 result에 킵해두고 left값을 m+1해서 m보다 더 큰값이 있나 찾아줌
    			result = m;
    			L = m+1;
    		}else {		//	거짓이라면 m보다 큰값이 없기에 right값을 m-1을 해서 값을 찾아줌
    			R = m-1;
    		}
    	}
    }
    
    static boolean Cal(int len) {// 길이에 맞게 계산
    	router = new ArrayList<>();
    	router.add(house.get(0));// 첫번째 집에 공유기 설치함
    	
    	int lastInstalled = house.get(0);// 마지막 설치
    	
    	for(int i=1; i<N; i++) {
    		if(lastInstalled + len <= house.get(i)) {// 마지막설치한 집보다 len의 거리 보다 크거나 같으면 됌
    			router.add(house.get(i));
    			lastInstalled = house.get(i);
    			
    			if(router.size() == C) {// C개만큼 설치를 다 했다면 종료
    				return true;
    			}
    		}
    	}
    	return false;
    }
}