import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 그래프를 저장할 리스트와, 각 건물의 진입 차수, 건설 시간 배열
    static ArrayList<ArrayList<Integer>> graph;
    static int[] inDegree;
    static int[] time;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 건물의 수를 읽어옴
        N = Integer.parseInt(br.readLine());
        
        // 그래프와 관련 배열 초기화
        graph = new ArrayList<>();
        inDegree = new int[N + 1];
        time = new int[N + 1];
        
        // 그래프 초기화: 각 건물에 대해 빈 리스트를 생성
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            // 현재 건물의 건설 시간을 설정
            time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            // 선행 작업이 있는 경우 그래프와 인디그리 배열을 업데이트
            while (num != -1) {
                graph.get(num).add(i); // num 건물이 i 건물의 선행 작업
                inDegree[i]++; // i 건물의 진입 차수를 증가
                num = Integer.parseInt(st.nextToken());
            }
        }//================= 입력 완료 =====================
        
        Queue<Integer> q = new ArrayDeque<>();
        
        int[] minTime = new int[N + 1];

        // 인디그리가 0인 노드를 큐에 추가하고, 해당 건물의 최소 건설 시간 초기화
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                minTime[i] = time[i];
            }
        }// 인디그리가 0이 라면 선행작업이 없으므로 바로 minTime에 time값을 넣어줌
        
        // 위상정렬
        while (!q.isEmpty()) {
            int node = q.poll();
            // 현재 노드의 모든 후속 작업을 처리
            for (int next : graph.get(node)) {
            	// 1번 작업이 빠졌으므로 1번 작업이 선행작업이던 다른 작업들의 인디그리를 감소시킴
                inDegree[next]--; // 후속 작업의 인디그리 감소
                // 후속 작업의 최소 건설 시간을 업데이트
                minTime[next] = Math.max(minTime[next], minTime[node] + time[next]);
                // 만약 후속 작업의 인디그리가 0이 되면 큐에 추가
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        // 결과를 출력하기 위한 StringBuilder 생성
        StringBuilder sb = new StringBuilder();
        // 각 건물의 최소 건설 완료 시간을 출력
        for (int i = 1; i <= N; i++) {
            sb.append(minTime[i]).append("\n");
        }
        // 최종 결과를 출력
        System.out.print(sb);
    }
}
