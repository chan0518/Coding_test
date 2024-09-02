import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static StringBuilder sb = new StringBuilder();
    static int[][] edges;
    static int[] parent;
    static int T;
    static int N, M;
    static int result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.valueOf(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#" + test_case + " ");
            /////////////////////////////////////////////////////////////////////////////////////////////

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            edges = new int[M][2]; // 엣지리스트 만들어줌
            result = 0;

            for (int i = 0; i < M; i++) { // 입력값을 받아서 엣지에 넣어줌
                st = new StringTokenizer(br.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
            }

            // 자신이 가리키는 부모가 누군지 초기화 시킴
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) parent[i] = i;

            for (int i = 0; i < M; i++) {
                if (find(edges[i][0]) != find(edges[i][1])) { // 부모가 다를 때
                    union(edges[i][0], edges[i][1]);
                }
            }
            
            for(int i=1; i<=N; i++) if(parent[i] == i) result++;
            
            /////////////////////////////////////////////////////////////////////////////////////////////
            sb.append(result + "\n");
        }
        System.out.print(sb.toString());
    }

    // a와 b의 부모를 찾아서 큰 값이 작은값을 부모로 섬김
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    // 부모 찾기 (경로 압축 적용)
    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]); // 경로 압축
    }
}


/*

2
6 5
1 2
2 5
5 1
3 4
4 6
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
*/