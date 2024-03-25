import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int a = Integer.valueOf(str[0]);
        int b = Integer.valueOf(str[1]);
        String[] Z = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        ArrayList<Integer> li = new ArrayList();

        for (int i=0; a != 0; i++){
            li.add(a%b);
            a /= b;
        }
        for (int i=li.size()-1; i>=0; i--) System.out.print(Z[li.get(i)]);
    }
}