import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[6];

        for (int i=0; i<6; i++) arr[i] = sc.nextInt();
        int T = sc.nextInt();
        int P = sc.nextInt();

        int t = 0;
        for (int i=0; i<6; i++) t += arr[i]%T == 0 ? arr[i]/T:arr[i]/T+1;
        System.out.println(t);
        int p1 = N/P, p2 = N%P;
        System.out.println(p1+" "+p2);
    }
}
