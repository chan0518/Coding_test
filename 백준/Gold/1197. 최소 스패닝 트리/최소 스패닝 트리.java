import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static int[][] edges;
    static int[] parent;
    static long cost;
    static int V, E;
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 첫 번째 줄: V (정점의 수), E (간선의 수)
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new int[E][3];
        cost = 0;
        
        // E개의 간선 정보 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        
        // 부모 배열 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        
        // 간선을 가중치에 따라 오름차순 정렬
        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        // 최소 스패닝 트리 (MST) 계산
        for (int i = 0; i < E; i++) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
                cost += edges[i][2];
            }
        }
        
        // 결과 출력
        System.out.println(cost);
    }
    
    // 두 노드의 부모를 합침
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
    
    // 노드의 부모를 찾음 (경로 압축 기법 적용)
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}
