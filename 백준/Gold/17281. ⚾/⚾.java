import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader br;
    static StringTokenizer st;
	static int[][] arr;
	static int[] order = {1,2,3,4,5,6,7,8};
	static ArrayList<Integer> li = new ArrayList<>();
	static boolean[] visited = new boolean[8];
	static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N][9];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<9; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}// 입력 완료
    	dfs();
    	System.out.println(max);
    }
    
    static void Cal(){
    	int point = 0;
    	ArrayList<Integer> list = new ArrayList<>(li);
    	list.add(3, 0); // 4번 타자를 0번 타자로 고정
    	int idx = 0;
    	
    	for(int i=0; i<N; i++) {
    		boolean[] bases = new boolean[3]; // 1루, 2루, 3루
    		int out = 0;
    		while(out < 3) {
    			int hitter = arr[i][list.get(idx)];
    			idx = (idx + 1) % 9;
    			
    			if(hitter == 0) { // 아웃
    				out++;
    			} else { // 안타, 2루타, 3루타, 홈런
    				// 주자들 이동 처리
    				point += moveRunners(bases, hitter);
    			}
    		}
    	}
    	max = Math.max(max, point);
    }
    
    static int moveRunners(boolean[] bases, int hit) {
    	int score = 0;
    	// 홈런일 경우 모든 주자가 홈으로 돌아옴
    	if (hit == 4) {
    		for (int i = 0; i < 3; i++) {
    			if (bases[i]) {
    				score++;
    				bases[i] = false;
    			}
    		}
    		score++; // 타자 자신도 홈으로 돌아옴
    	} else {
    		// 주자들 이동
    		for (int i = 2; i >= 0; i--) {
    			if (bases[i]) {
    				if (i + hit >= 3) {
    					score++;
    				} else {
    					bases[i + hit] = true;
    				}
    				bases[i] = false;
    			}
    		}
    		// 타자가 타석에서 시작하는 이동
    		if (hit < 4) {
    			bases[hit - 1] = true;
    		}
    	}
    	return score;
    }
    
    static void dfs(){
    	if(li.size() == 8) {
    		Cal();
    		return;
    	}
    	for(int i=0; i<8; i++) {
    		if(visited[i]) continue;
    		visited[i] = true;
    		li.add(order[i]);
    		dfs();
    		visited[i] = false;
    		li.remove(li.size()-1);
    	}
    }
}
