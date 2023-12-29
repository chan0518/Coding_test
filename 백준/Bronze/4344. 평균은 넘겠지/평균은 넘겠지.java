import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        sc.nextLine();

        for (int i=0;i<C;i++){
            String[] a = sc.nextLine().split(" ");
            int[] aa = new int[a.length];
            for (int j=0;j<a.length;j++){//정수 변환
                aa[j] = Integer.valueOf(a[j]);
            }

            int sum=0;
            int w=0;
            for (int k=1;k<=aa[0];k++){// 모든 점수 합산
                sum += aa[k];
                w++;
            }
            double dsum=0;
            double avg=0;
            dsum = (double)sum;
            avg = dsum/aa[0];//평균
            int cnt=0;
            for (int k=1;k<=aa[0];k++){//평균보다 높은 갯수
                if ((double)aa[k]>avg) cnt++;
            }

            double result = (double)cnt/(double)aa[0]*100;
            DecimalFormat df = new DecimalFormat("#.000");
            String fr = df.format(result);
            System.out.println(fr+"%");

        }
    }
}