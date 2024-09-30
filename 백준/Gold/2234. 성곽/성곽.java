import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int roomSize;
    static int roomSizeMax = 0; // 방의 최대 사이즈
    static int roomSizeWithRemovedWall = 0; // 벽을 허물었을 때 최대 사이즈
    static int[][] map;
    static boolean[][] visited;
    static int[][] D = {
            {0, -1},    // 좌    서
            {-1, 0},    // 상    북
            {0, 1},     // 우    동
            {1, 0},     // 하    남
    };

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roomSize = 0;

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 완료

        int result = startXY(); // 방의 갯수
        System.out.println(result); // 방의 갯수 출력
        System.out.println(roomSizeMax); // 방의 최대 넓이 출력

        removeWall(); // 벽을 허물었을 때 최대 방 크기 계산
        System.out.println(roomSizeWithRemovedWall); // 벽을 허물었을 때의 최대 방 크기 출력
    }

    static int startXY() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ++cnt;
                    roomSize = 0;
                    bfs(new int[] { i, j }); // 방문하지 않았다면 bfs발동!
                    roomSizeMax = Math.max(roomSize, roomSizeMax);
                }
            }
        }
        return cnt;
    }

    static void bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ++roomSize; // q에서 꺼낸 만큼 넓이
            int x = cur[0];
            int y = cur[1];
            int wall = map[x][y];

            for (int i = 0; i < 4; i++) { // 서 -> 북 -> 동 -> 남 순서로 탐색
                if ((wall & (1 << i)) == 0) { // 벽이 없으면 탐색 가능
                    int nx = x + D[i][0];
                    int ny = y + D[i][1];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
    }

    // 벽을 하나 허물었을 때 최대 방 크기를 계산하는 함수
    static void removeWall() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int wall = map[i][j];
                
                for (int d = 0; d < 4; d++) {
                    // 현재 칸에서 각 방향에 벽이 있는지 확인
                    if ((wall & (1 << d)) != 0) { // 벽이 있다면
                        int nx = i + D[d][0];
                        int ny = j + D[d][1];

                        if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                            // 현재 방 크기 + 벽 너머의 방 크기
                            resetVisited(); // 새로운 탐색을 위해 방문 배열 초기화
                            int currentRoomSize = bfsSize(new int[] { i, j }); // 현재 방 크기
                            int nextRoomSize = bfsSize(new int[] { nx, ny });  // 벽 너머 방 크기
                            roomSizeWithRemovedWall = Math.max(roomSizeWithRemovedWall, currentRoomSize + nextRoomSize);
                        }
                    }
                }
            }
        }
    }

    // 새로운 bfs 탐색으로 방의 크기를 구하는 함수
    static int bfsSize(int[] start) {
        int size = 0;
        Queue<int[]> q = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            ++size; // q에서 꺼낸 만큼 넓이
            int x = cur[0];
            int y = cur[1];
            int wall = map[x][y];

            for (int i = 0; i < 4; i++) { // 서 -> 북 -> 동 -> 남 순서로 탐색
                if ((wall & (1 << i)) == 0) { // 벽이 없으면 탐색 가능
                    int nx = x + D[i][0];
                    int ny = y + D[i][1];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[] { nx, ny });
                    }
                }
            }
        }
        return size;
    }

    // 방문 배열 초기화 함수
    static void resetVisited() {
        for (int i = 0; i < M; i++) {
            Arrays.fill(visited[i], false);
        }
    }
}
