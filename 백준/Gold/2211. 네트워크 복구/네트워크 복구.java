import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] distance, connect;
    static int INF = (int)1e9;
    static class Edge implements Comparable<Edge>{
        int num;
        int dis;
        public Edge(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
        @Override
        public int compareTo(Edge o) {
            return this.dis - o.dis;
        }
    }

    public static ArrayList<Edge>[] list;
    public static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        distance = new int[N+1];
        connect = new int[N+1];

        for(int i=0;i<N+1;i++) list[i] = new ArrayList<Edge>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, dis));
            list[b].add(new Edge(a, dis));
        }

        Arrays.fill(distance, INF);
        dijkstra();

        for(int i=2;i<=N;i++){
            if(connect[i] == 0) continue;
            cnt++;
            sb.append(i+ " " + connect[i]+"\n");
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    public static void dijkstra(){
        distance[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while (!pq.isEmpty()){
            Edge edge = pq.poll();

            if(edge.dis > distance[edge.num]) continue;

            for(Edge e : list[edge.num]){
                if(distance[e.num] > e.dis + edge.dis){
                    distance[e.num]  = e.dis + edge.dis;
                    connect[e.num] = edge.num;
                    pq.add(new Edge(e.num, distance[e.num]));
                }
            }
        }
    }
}