import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int result = a*b*c;
        String Sresult = String.valueOf(result);
        int rl = Sresult.length();
        int[] intArray = {0,0,0,0,0,0,0,0,0,0};

        int z = 1;
        for (int i=0;i<rl-1;i+=1){
            z*=10;
        }
        int rain;
        for (int i=rl;i>0;i-=1){//해당 값에 +1
            rain = result/z;
            intArray[rain] +=1;
            result = result%z;
            z /= 10;
//            System.out.println("rain = "+rain+ ", z = "+ z+", result = "+result);
        }
        for (int e: intArray){//출력
            System.out.println(e);
        }
    }
}