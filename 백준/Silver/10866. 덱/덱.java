import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int arr[] = new int[N*2];

        int front = N;
        int back = N;
        int cnt = 0;

        for (int i=0; i<N; i++){
            String a[] = br.readLine().split(" ");
            
            if (a[0].equals("push_front")){
                if (cnt == 0) arr[front] = Integer.valueOf(a[1]);
                else arr[++front] = Integer.valueOf(a[1]);
                cnt++;
            } else if (a[0].equals("push_back")) {
                if (cnt == 0) arr[back] = Integer.valueOf(a[1]);
                else arr[--back] = Integer.valueOf(a[1]);
                cnt++;
            }else if (a[0].equals("pop_front")) {
                if (cnt >= 1){
                    bw.write(arr[front]+"\n");
                    arr[front] = 0;
                    if (cnt >= 2) front--;
                    cnt--;
                } else bw.write("-1"+"\n");
            }else if (a[0].equals("pop_back")) {
                if (cnt >= 1){
                    bw.write(arr[back]+"\n");
                    arr[back] = 0;
                    if (cnt >= 2) back++;
                    cnt--;
                }else bw.write("-1\n");
            }else if (a[0].equals("size")) {
                bw.write(cnt+"\n");
            }else if (a[0].equals("empty")) {
                bw.write(cnt < 1 ? "1"+"\n":"0"+"\n");
            }else if (a[0].equals("front")) {
                bw.write(cnt < 1 ? "-1"+"\n":arr[front]+"\n");
            } else if (a[0].equals("back")) {
                bw.write(cnt < 1 ? "-1"+"\n":arr[back]+"\n");
            }
        }
        bw.close();
    }
}