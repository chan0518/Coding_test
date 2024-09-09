
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Node implements Comparable<Node> {
    int x;
    int y;
    int cnt;
 
    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
 
    @Override
    public int compareTo(Node o) {
        return cnt - o.cnt;
    }
}
 
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] D = {
    		{-1,0},
    		{0,1},
    		{1,0},
    		{0,-1},
    };
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
 
        map = new int[N + 1][M + 1];
 
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j - 1));
            }
        }
 
        int result = bfs(1, 1);
 
        System.out.println(result);
    }
 
    public static int bfs(int x, int y) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[][] visit = new boolean[N + 1][M + 1];
 
        q.offer(new Node(x, y, 0));
        visit[x][y] = true;
 
        int nx, ny;
        while (!q.isEmpty()) {
            Node p = q.poll();
 
            // 도착점에 도달했으면 종료.
            if (p.x == N && p.y == M) {
                return p.cnt;
            }
 
            for (int i = 0; i < 4; i++) {
                nx = p.x + D[i][0];
                ny = p.y + D[i][1];
 
                if (nx < 1 || ny < 1 || nx > N || ny > M) {
                    continue;
                }
 
                if (!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.offer(new Node(nx, ny, p.cnt));
                }
 
                if (!visit[nx][ny] && map[nx][ny] == 1) {
                    visit[nx][ny] = true;
                    q.offer(new Node(nx, ny, p.cnt + 1));
                }
            }
        }
        return 0;
    }
 
}