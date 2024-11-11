import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;

	// 이동 방향 배열: 상, 하, 좌, 우, 말 이동 8방향
	static int[][] moves = {
			{-1, 0}, {1, 0}, {0, -1}, {0, 1},   // 원숭이 이동 (상, 하, 좌, 우)
			{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}  // 말 이동 8방향
	};

	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, K, 0 });
		visited[0][0][K] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int k = cur[2];
			int dep = cur[3];

			// 목표 위치 도달 시 깊이 반환
			if (x == H - 1 && y == W - 1) {
				System.out.println(dep);
				return;
			}

			// 12방향 반복: 상, 하, 좌, 우 (인덱스 0~3), 말 이동 (인덱스 4~11)
			for (int i = 0; i < 12; i++) {
				int nx = x + moves[i][0];
				int ny = y + moves[i][1];

				// 범위 체크
				if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
				if (map[nx][ny] == 1) continue;

				// 원숭이 이동(0~3)과 말 이동(4~11) 구분하여 방문 체크
				if (i < 4) { // 원숭이 이동
					if (!visited[nx][ny][k]) {
						visited[nx][ny][k] = true;
						q.add(new int[] { nx, ny, k, dep + 1 });
					}
				} else if (k > 0) { // 말 이동
					if (!visited[nx][ny][k - 1]) {
						visited[nx][ny][k - 1] = true;
						q.add(new int[] { nx, ny, k - 1, dep + 1 });
					}
				}
			}
		}

		// 도달 불가능 시 -1 출력
		System.out.println(-1);
	}
}
