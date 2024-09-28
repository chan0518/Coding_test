import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int num; // 초기의 빙산이 있는 칸의 수
    static int[][] map;
    static int[][] D = {
        {-1, 0}, // 북
        {1, 0},  // 남
        {0, -1}, // 서
        {0, 1},  // 동
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) ++num;
            }
        }//입력완료
        
        int time = 0;
        while (true) {
        	int[] startXY = findStart();
        	
        	if(startXY[0] <0) {
        		System.out.println(0);
        		return;
        	}
        	
        	int c = check(startXY);
        	int f = fuzeAndIcebergCnt(startXY);
//        	System.out.println(c + " " + f);
//        	System.out.println();
//        	for(int[] e : map) System.out.println(Arrays.toString(e));
            
            if (c != f) {// 전체 빙하의 면적 개수랑 빙하가 bfs로 세어진 갯수가 다르다면 2개이상으로 분리된 것
                System.out.println(time);
                return;
            }
            ++time;
        }
    }

    static int[] findStart() { // 빙산 시작점 좌표 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                	return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    static int check(int[] startXY) {// 전체 빙하의 면적 개수
    	int cnt = 0;
    	
    	for(int i=startXY[0]; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(map[i][j] > 0) {
    				++cnt;
    			}
    		}
    	}
    	return cnt;
    }

//    static int check(int[] start) { // 빙산 덩어리 체크
//        Queue<int[]> q = new ArrayDeque<>();
//        boolean[][] visited = new boolean[N][M];
//        q.add(start);
//        visited[start[0]][start[1]] = true;
//        int cnt = 1;
//
//        while (!q.isEmpty()) {
//            int[] cur = q.poll();
//            int x = cur[0];
//            int y = cur[1];
//
//            for (int[] d : D) {
//                int nx = x + d[0];
//                int ny = y + d[1];
//
//                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !visited[nx][ny]) {
//                    q.add(new int[]{nx, ny});
//                    visited[nx][ny] = true;
//                    ++cnt;
//                }
//            }
//        }
//        return cnt;
//    }

    static int fuzeAndIcebergCnt(int[] startXY) { // 빙산을 녹이고 녹인 빙산의 개수를 세어줌
    	Queue<int[]> q = new ArrayDeque<>();
    	boolean[][] visited = new boolean[N][M];
    	q.add(startXY);// 빙산의 시작점 좌표 추가
    	visited[startXY[0]][startXY[1]] = true;
    	int icebergCnt = 1; // 빙산이 차지하는 면적 개수
    
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int x = cur[0];
    		int y = cur[1];
    		
    		int zeroCnt = 0;// 주변에 0이 있는 개수
    		
    		for (int[] d : D) {
                int nx = x + d[0];
                int ny = y + d[1];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny]) {// N, M 범위 안에 있을 때
                	if(map[nx][ny] > 0) {// 0보다 크면 q에 추가
                		q.add(new int[] {nx, ny});
                		visited[nx][ny] = true;
                		++icebergCnt;// 탐색 할 빙산의 개수 카운트
                		
                	}
                	else if(map[nx][ny] == 0) {
                		++zeroCnt;// 주변에 0이 있다면 증가
                	}
                }
            }
    		map[x][y] -= zeroCnt;// 주변에 0이 있었던 만큼 감소
    		if(map[x][y] <= 0) map[x][y] = 0;// -라면 0으로
    	}
    	return icebergCnt;
    }
}

