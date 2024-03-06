import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.valueOf(br.readLine());
        int arr[] = new int[K];

        int idx = -1;
        for (int i=0; i<K; i++){
            int num = Integer.valueOf(br.readLine());//숫자를 받는다
            if (num == 0){//받은 숫자가 0이라면 최근 인덱스의 값을 0으로 만들고 인덱스를 1감소한다
                arr[idx--] = 0;
            }else {//받은 숫자가 0이 아니라면 인덱스를 1증가 시키고 값을 넣는다
                arr[++idx] = num;
            }
        }

        int sum = 0;
        int i = 0;
        while (i < K && arr[i] != 0){//arr값이 0이 아니라면 반복문 실행
            sum += arr[i];//sum에다가 arr에 있는 숫자값들의 합을 저장
            i++;
        }

        bw.write(String.valueOf(sum));
        bw.close();
    }
}