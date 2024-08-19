import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, D;
    static int[][] map;
    static boolean[] selected;
    static int[] archers;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        archers = new int[3];
        selected = new boolean[M];
        dfs(0, 0);
        
        System.out.println(cnt);
    }

    // 조합을 생성하는 DFS 함수
    static void dfs(int depth, int start) {
        if (depth == 3) {
            cnt = Math.max(cnt, simulate());
            return;
        }
        
        for (int i = start; i < M; i++) {
            archers[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    // 시뮬레이션 함수
    static int simulate() {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }

        int killCnt = 0;
        
        for (int round = 0; round < N; round++) {
            boolean[][] targetMark = new boolean[N][M];
            List<int[]> targets = new ArrayList<>();
            
            for (int i = 0; i < 3; i++) {
                int archerCol = archers[i];
                targets.add(findTarget(tempMap, archerCol));
            }
            
            for (int[] target : targets) {
                if (target != null && tempMap[target[0]][target[1]] == 1) {
                    killCnt++;
                    tempMap[target[0]][target[1]] = 0;
                }
            }
            
            moveEnemies(tempMap);
        }
        
        return killCnt;
    }

    // 주어진 궁수 위치에서 가장 가까운 적을 찾는 함수
    static int[] findTarget(int[][] map, int archerCol) {
        int minD = D + 1;
        int[] target = null;
        
        for (int r = N - 1; r >= 0; r--) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    int distance = Math.abs(N - r) + Math.abs(archerCol - c);
                    if (distance < minD) {
                        minD = distance;
                        target = new int[] {r, c};
                    } else if (distance == minD && target != null && c < target[1]) {
                        target = new int[] {r, c};
                    }
                }
            }
        }
        return target;
    }

    // 적을 한 칸씩 아래로 이동시키는 함수
    static void moveEnemies(int[][] map) {
        for (int r = N - 1; r > 0; r--) {
            for (int c = 0; c < M; c++) {
                map[r][c] = map[r - 1][c];
            }
        }
        for (int c = 0; c < M; c++) {
            map[0][c] = 0;
        }
    }
}
