import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String arr[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J",
                        "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        String aa[] = br.readLine().split(" ");
        String a[] = aa[0].split("");
        int b = Integer.valueOf(aa[1]);

        int sum = 0;
        int zegob = 0;
        for (int i=a.length-1; i>=0; i--){
            for (int j=1; j<b; j++){
                if (a[i].equals(arr[j])) {
                    sum += (int) Math.pow(b, zegob) * j;
                    zegob++;
                    break;
                } else if (a[i].equals("0")) {
                    zegob++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.close();
    }
}