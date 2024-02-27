import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        int arr[] = new int[N];
        int front_idx = 0;
        int back_idx = -1;
        int cnt = 0;
        while (N-- > 0) {
            String a[] = br.readLine().split(" ");

            if (a[0].equals("push")) {
                arr[++back_idx] = Integer.valueOf(a[1]);
                cnt++;
            }
            else if (a[0].equals("pop")) {
                if (cnt >= 1 ){
                    cnt--;
                    bw.write(arr[front_idx] + "\n");
                    arr[front_idx++] = 0;
                }
                else if (cnt <= 0) bw.write(-1 + "\n");
            }
            else if (a[0].equals("size")) {
                bw.write(cnt+"\n");
            }
            else if (a[0].equals("empty")) {
                if (cnt >= 1) bw.write(0+"\n");
                else bw.write(1+"\n");
            }
            else if (a[0].equals("front")) {
                if (cnt >= 1) bw.write(arr[front_idx]+"\n");
                else bw.write(-1+"\n");
            }
            else if (a[0].equals("back")) {
                if (cnt >= 1) bw.write(arr[back_idx]+"\n");
                else bw.write(-1+"\n");
            }
        }
        bw.close();
    }
}