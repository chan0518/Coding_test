import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, result;
    static int continentNum = 3; // 대륙 번호는 3부터 시작
    static int[][] map;
    static boolean[][] visited;
    static int[][] D = {
            {-1, 0}, // 상
            {1, 0},  // 하
            {0, -1}, // 좌
            {0, 1}   // 우
    };

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료
        
        startXY(); // 대륙끼리 묶어줌
        startBfs(); // 대륙마다 다른대륙으로 bfs돌아줌
        
        // 출력
        System.out.println(result);
    }

    static void startXY() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) { // 대륙을 발견하면
                    setContinentNum(new int[]{i, j});
                }
            }
        }
    }
    
    static void startBfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 2) { // 대륙 번호가 2보다 큰 경우 (즉, 이미 번호가 매겨진 대륙)
                    bfs(new int[]{i, j, 0});
                }
            }
        }
    }

    static void setContinentNum(int[] s) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(s);
        map[s[0]][s[1]] = continentNum; // 대륙별 3부터 값을 넣어줌

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] d : D) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    map[nx][ny] = continentNum; // 현재 대륙 번호를 할당
                }
            }
        }
        continentNum++; // 대륙 번호를 증가시킴
    }
    
    static void bfs(int[] s) {
        int num = map[s[0]][s[1]];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s[0], s[1], 0});
        visited = new boolean[N][N];
        visited[s[0]][s[1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dep = cur[2];

            for (int[] d : D) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny]) {
                        if (map[nx][ny] == 0) {
                            q.add(new int[]{nx, ny, dep + 1}); // depth 증가
                            visited[nx][ny] = true;
                        } else if (map[nx][ny] != num) {
                            result = Math.min(result, dep); // 다른 대륙을 만날 때
                        }
                    }
                }
            }
        }
    }
}
