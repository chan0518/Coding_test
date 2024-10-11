import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int vertex, edge;
    static HashMap<Integer, List<Integer>> hm;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        visited = new boolean[vertex+1];
        hm = new HashMap<>();

        for(int i=0; i<edge; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(hm.get(a) == null) hm.put(a, new ArrayList());
            if(hm.get(b) == null) hm.put(b, new ArrayList());
            hm.get(a).add(b);
            hm.get(b).add(a);
        }// 양방향 hm 입력완료
        System.out.println(bfs());
    }

    static int bfs(){
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()){
            int cur = q.poll();

            if(hm.get(cur) != null){

                for(int i=0; i<hm.get(cur).size(); i++){
                    int num = hm.get(cur).get(i);
                    if(!visited[num]){
                        q.add(num);
                        visited[num] = true;
                        ++cnt;
                    }
                }

            }
        }
        return cnt;
    }
}