import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] two (int[][] arr,int ten,int n){
        for (int i=0; ten>0; i++){
            arr[n][i] = ten%2;
            ten /= 2;
        }
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[][] arr = new int[N][20];

        for (int i=0; i<N; i++) arr = two(arr, Integer.valueOf(br.readLine()), i);//이진수로 변환하고 값을 넣음

        long num = 0;//행성가치의 합
        for (int j=0; j<20; j++) {
            long zero = 0, one = 0;//zero는 0의 개수, one은 1의 개수
            for (int i=0; i<N; i++){//j자리 수의 0의 개수 1의 개수를 센다
                if (arr[i][j] == 0) zero++;
                else one++;
            }
            num += zero * one * (long)Math.pow(2,j);//j자리의 행성가치를 num에 저장
        }//0의 개수 * 1의 개수 * 2진수의 자리값 이 값을 다 더한다면 모든 값을 2개씩 XOR한 값의 합한 값이랑 같음
        System.out.println(num);
    }
}