import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt=0;
        //1 1개
        //2~7 6개        1~6
        //8~19 12개      7~18
        //20~37 18개     19~36
        N=N-1;
        for (int i=1;N>0;i+=1){
            N = N-(i*6);
            cnt=i;
        }
        System.out.println(1+cnt);
    }
}