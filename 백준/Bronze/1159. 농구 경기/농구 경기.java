import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] e = new String[N];
        for (int i=0; i<N; i++){
            char a = sc.next().charAt(0);
            e[i] = String.valueOf(a);
        }
        Set<String> set = new HashSet<>(Arrays.asList(e));
        String[] ee = set.toArray(new String[0]);

        int[] n = new int[e.length];
        for (int i=0;i<e.length;i++) n[i] = 0;

        for (int i=0; i<N; i++){
            for (int j=0; j<ee.length; j++){
                if (e[i].equals(ee[j])) n[j] += 1;
            }
        }

        String ww = "";
        for (int j=0; j<e.length; j++){
            if (n[j] >= 5) ww += ee[j];
        }
        System.out.println(ww.isEmpty() ? "PREDAJA" : ww);
    }
}
