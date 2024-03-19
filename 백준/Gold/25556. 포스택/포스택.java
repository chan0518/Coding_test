
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.valueOf(br.readLine());
        String a[] = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.valueOf(a[i]);

        Stack<Integer>[] stack = new Stack[4];
        for (int i = 0; i < 4; i++) stack[i] = new Stack<>();

        Loop1:
        for (int j=0; j<N; j++) {
            Loop2:
            for (int i = 0; i < 4; i++) {
                if (stack[i].empty()) {//스택이 비어 있으면 집어 넣어라
                    stack[i].push(arr[j]);
                    continue Loop1;//집어 넣었으니 arr의 다음 값을 넣기 위해 continue
                }
                else {//empty == false라면, 비어있지 않다면
                    if (stack[i].peek() < arr[j]) {
                        stack[i].push(arr[j]);//top이 작다면 push
                        continue Loop1;//값을 넣었으니 arr의 다음 값을 위해 continue
                    }
                    else continue Loop2;
                    //else를 써도 안써도 코드상 의미가 없음 => top이 크다면 옆 스택으로 넘김
                }
            }
        }

        int stack_size_sum = 0;
        for (int i = 0; i < 4; i++) stack_size_sum += stack[i].size();

        bw.write(stack_size_sum == N ? "YES" : "NO");
        br.close();
        bw.close();
    }
}
