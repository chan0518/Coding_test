import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ans = 0;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set.add(a);
            set.add(b);

            if(map.get(a)==null) map.put(a, new ArrayList<>());
            map.get(a).add(b);
            if(map.get(b)==null) map.put(b, new ArrayList<>());
            map.get(b).add(a);
        }// 입력 끝

        for(int e : set){
            if(!visited[e]){
                bfs(e);
                ans++;
            }
        }
        for(boolean e : visited){
            if(!e) ans++;
        }
        ans--; // 0번 인덱스까지 더해서 -1 해줌

        System.out.println(ans);
    }

    static void bfs(int node){
        Deque<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(Integer e : map.get(cur)){
                if(visited[e]) continue;
                q.add(e);
                visited[e] = true;
            }
        }
    }
}
