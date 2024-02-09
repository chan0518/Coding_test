import java.io.*;
import java.util.Arrays;

public class Main {//10989
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.valueOf(br.readLine());

        bw.write(String.valueOf((a/5) + (a/25) + (a/125)));
        //5의 배수의 갯수로 a/5를 하면 값이 나오고
        //25의 배수는 5가 2개 씩 들어갔으나 5의 배수 갯수를 셌을 때 1을 뺏으니
        //25의 배수 갯수만 세어주고
        //125의 배수는 5가 3개 씩 들어간 값이지만 5와 25의 배수갯수를 계산 할 때 1개 씩
        //즉 2개를 뺏으니 125의 배수의 갯수를 세어보면 나머지 5의 배수 값을 얻을 수 있다
        
        //ex) 25 = 5x5, 125 = 5x5x5
        //5의 배수의 갯수를 셀 때
        // 25는 2개, 125는 3개의 5가 들어 있으니
        //5의 배수 갯수, 25의 배수 갯수, 125의 배수 갯수를 세면
        //총 5가 몇개 있는지 알 수 있다.
        
        bw.close();
    }
}