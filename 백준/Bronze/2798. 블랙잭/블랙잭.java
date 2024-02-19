import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a[] = br.readLine().split(" ");//첫번째 줄 입력 받음 ex) 5 21
        int n = Integer.valueOf(a[0]);//ex) n=5
        int m = Integer.valueOf(a[1]);//ex) n=21

        // 10개    0 1 2 3 4 5 6 7 8 9   -> 10개 0~9

        String arr[] = br.readLine().split(" ");//두번째 줄 입력 받음 ex) 5,6,7,8,9
        int sum=0;//합한 값
        int num=0;//최종 값
        for (int i=0; i<n-2; i++){//0~n까지 니까 n번 반복 i는 반복 할 때마다 1씩 증가
            for (int j=i+1; j<n-1; j++){//이하동문
                for (int k=j+1; k<n; k++){//이하 동문
                    sum = Integer.valueOf(arr[i]) + Integer.valueOf(arr[j]) + Integer.valueOf(arr[k]);//Integer.valueOf는 문자값을 숫자값으로 바꿔줌 ex) "21" -> 21
                    if (sum <= m && sum > num){//&& -> and
                        num = sum;
                    }
                }
            }
        }
        bw.write(String.valueOf(num));//출력
        bw.newLine();
        bw.close();
    }
}