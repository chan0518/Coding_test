import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i=0;i<T;i+=1){
            int cnt=0;
            String a = sc.nextLine();
            String[] aa = new String[a.length()];
            aa = a.split("");

            for (int j=0;j<aa.length;j+=1){
                if (aa[j].equals("(")){
                    cnt+=1;
                }else if (aa[j].equals(")")){
                    cnt-=1;
                }
                if (cnt == -1){
                    break;
                }
            }
            System.out.println(cnt==0 ? "YES":"NO");
        }
    }
}