import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int[] parent;
    public static class Node implements Comparable<Node>{
        int s;
        int e;
        int d;
        public Node(int s, int e, int d){
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        ArrayList<Node> edges = new ArrayList<>();
        parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a, b, c));
        }

        Collections.sort(edges);
        int cnt = 0;
        int cost = 0;
        for(Node node:edges){
            if(find_parent(node.s) != find_parent(node.e)){
                cost += (cnt * T + node.d);
                union(node.s, node.e);
                cnt++;
            }
        }

        System.out.println(cost);
    }

    public static int find_parent(int x){
        if(x == parent[x]) return x;
        return parent[x] = find_parent(parent[x]);
    }

    public static void union(int a, int b){
        a = find_parent(a);
        b = find_parent(b);
        if(a < b){
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}