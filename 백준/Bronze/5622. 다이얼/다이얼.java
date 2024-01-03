import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input;
        int output = 0;
        int sum=0;
        String a = sc.nextLine();

        for (int i=0;i<a.length();i++){
            input = a.charAt(i);
            if ((input=='A')||(input=='B')||(input=='C')){
                output = 2;
            } else if ((input=='D')||(input=='E')||(input=='F')) {
                output = 3;
            } else if ((input=='G')||(input=='H')||(input=='I')) {
                output = 4;
            }else if ((input=='J')||(input=='K')||(input=='L')) {
                output = 5;
            }else if ((input=='M')||(input=='N')||(input=='O')) {
                output = 6;
            }else if ((input=='P')||(input=='Q')||(input=='R')||(input=='S')) {
                output = 7;
            }else if ((input=='T')||(input=='U')||(input=='V')) {
                output = 8;
            }else if ((input=='W')||(input=='X')||(input=='Y')||(input=='Z')) {
                output = 9;
            }
            sum += output+1;
        }
        System.out.println(sum);
    }
}