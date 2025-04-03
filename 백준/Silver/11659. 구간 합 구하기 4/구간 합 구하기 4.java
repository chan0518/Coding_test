import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int N,M;
    static int[] arr, prefixSum;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        prefixSum = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            prefixSum[i+1] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[b] - prefixSum[a - 1]).append("\n");
        }
        System.out.println(sb);
        
    }
}