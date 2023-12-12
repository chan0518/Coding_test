import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String M = sc.nextLine();
        int result = 0;
        String[] m = M.split(" ");
        int[] a = new int[m.length];
        for (int i=0;i<m.length;i+=1){
            a[i]= Integer.valueOf(m[i]);
        }

        for (int j=0;j<N;j+=1){
            int cnt = 0;
            int[] array = new int[a[j]];
            for (int i=0;i<array.length;i+=1){
                array[i] = i+2;
            }

            for(int i=0;i<array.length;i+=1){
                  if (a[j]%array[i]==0){
                      cnt+=1;
                  }
            }
            if (cnt==1){
                result+=1;
            }
        }
        System.out.println(result);
    }
}
