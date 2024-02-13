import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.valueOf(br.readLine());
        //2 : 1 4 10
        //1 : 1 3 6
        //0 : 1 2 3
        for (int i=0; i<T; i++){
            int k = Integer.valueOf(br.readLine());
            int n = Integer.valueOf(br.readLine());

            int arr[][] = new int[k+1][n];
            for (int j=0; j<n; j++){
                arr[0][j] = j+1;
            }
            if (k >= 1){
                for (int j=1; j<=k; j++){
                    for (int w=0; w<n; w++){
                        if (w == 0) arr[j][w] = 1;
                        else {
                            int sum = 0;
                            for (int p=0; p<=w; p++){
                                sum += arr[j-1][p];
                            }
                            arr[j][w] = sum;
                        }
                    }
                }
            }
            bw.write(String.valueOf(arr[k][n-1]));
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}