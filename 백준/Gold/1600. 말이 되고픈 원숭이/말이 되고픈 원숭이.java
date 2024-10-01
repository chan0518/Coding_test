import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited; // 3차원 배열로 방문 상태를 기록
    static int[][] D = {
            {-1, 0}, // 상
            {1, 0},  // 하
            {0, -1}, // 좌
            {0, 1},  // 우
    };

    static int[][] Horse = {
            {-2, 1},  //1
            {-1, 2},  //2
            {1, 2},   //3
            {2, 1},   //4
            {2, -1},  //5
            {1, -2},  //6
            {-1, -2}, //7
            {-2, -1}, //8
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1]; // K + 1 만큼의 차원 추가

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료
        
        //출력
//        for(int[] e : map) System.out.println(Arrays.toString(e));
        
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, K}); // (x,y)좌표, cnt, K
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2]; // 이동 횟수
            int k = cur[3];

            if (x == H - 1 && y == W - 1) {
                return cnt; // 이동 횟수 반환
            }

            for (int[] d : D) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (0 <= nx && nx < H && 0 <= ny && ny < W && !visited[nx][ny][k] && map[nx][ny] == 0) {
                    visited[nx][ny][k] = true; // 방문 처리
                    queue.add(new int[]{nx, ny, cnt + 1, k});
                }
            }

            // 말처럼 이동
            if (k > 0) {
                for (int[] HM : Horse) {
                    int nx = x + HM[0];
                    int ny = y + HM[1];

                    if (0 <= nx && nx < H && 0 <= ny && ny < W && !visited[nx][ny][k - 1] && map[nx][ny] == 0) {
                        visited[nx][ny][k - 1] = true; // 방문 처리
                        queue.add(new int[]{nx, ny, cnt + 1, k - 1}); // 큐에 추가
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
