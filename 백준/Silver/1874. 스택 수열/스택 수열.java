import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        String str[] = new String[n*2];
        int str_idx = 0;
        int arr[] = new int[n];
        int arr_idx = 0;
        for (int i=0; i<n; i++) arr[i] = Integer.valueOf(br.readLine());
        //-----------------------------------------------------------------------------
        int num[] = new int[n];
        for (int i=0; i<n; i++) num[i] = i+1;

        int stack[] = new int[n];
        int stack_idx = -1;
        int result[] = new int[n];
        int result_idx = -1;

        for (int i=0; i<n; i++){
            str[str_idx++] = "+";
            stack[++stack_idx] = num[i];
            num[i] = 0;

            while (arr[arr_idx] == stack[stack_idx]){
                str[str_idx++] = "-";
                result[++result_idx] = stack[stack_idx];
                stack[stack_idx] = 0;
                if (arr_idx+1 < n)arr_idx++;
                if (stack_idx > 0) stack_idx--;
            }
        }
        int cnt=0;
        for (int i=0; i<n; i++){
            if (arr[i] == result[i]) cnt++;
        }

        if (cnt == n) {
            for (int i=0; i<n*2; i++) bw.write(str[i]+"\n");
        }else bw.write("NO");
        bw.close();
    }
}
