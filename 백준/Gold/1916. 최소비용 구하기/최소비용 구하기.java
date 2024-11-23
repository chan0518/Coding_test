import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, S, E, result;
    static List<List<Edge>> graph = new ArrayList<>(); // 양방향 그래프
    
    static class Edge {
        int e, w;
        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        result = 0;

        // 그래프 초기화
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        // 그래프 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발
            int b = Integer.parseInt(st.nextToken()); // 도착
            int w = Integer.parseInt(st.nextToken()); // 비용

            // 단방향 그래프
            graph.get(a).add(new Edge(b, w)); // a -> b
        }

        // 출발지 S, 도착지 E 입력
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(result);
    }

    static void dijkstra() {
        // 우선순위 큐 선언, 최소 가중치를 기준으로 노드를 뽑음
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[] {S, 0}); // 출발 노드, 가중치 0으로 시작

        boolean[] visited = new boolean[N + 1]; // 방문 여부 체크

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int n = cur[0]; // 현재 노드
            int w = cur[1]; // 누적 가중치

            // 이미 방문한 노드는 skip
            if (visited[n]) continue;
            visited[n] = true;

            // 목표 지점에 도달하면 결과 출력
            if (n == E) {
                result = w;
                return;
            }

            // 인접 노드들에 대해 최단거리 갱신
            for (Edge edge : graph.get(n)) {
                int next = edge.e;
                int newWeight = w + edge.w;

                // 인접 노드를 큐에 넣을 때, 이미 방문한 노드가 아니라면 큐에 넣는다
                if (!visited[next]) {
                    pq.add(new int[] {next, newWeight});
                }
            }
        }
    }
}
